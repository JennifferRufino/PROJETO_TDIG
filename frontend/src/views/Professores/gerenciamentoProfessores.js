import React, { useEffect } from "react";
import axios from 'axios';
// @material-ui/core components
import { makeStyles } from "@material-ui/core/styles";
import MaterialTable from "material-table";

const GerenciamentoProfessores = props => {
    const { useState } = React;
  
    const [columns, setColumns] = useState([
      { title: 'Id', field: 'id' },
      { title: 'matricula', field: 'matricula', type: 'numerico' },
      { title: 'nome', field: 'nome' },
      { title: 'curso', field: 'curso' },
      { title: 'endereço', field: 'idEnderedo', type: 'numerico' }
    ]);
  
    const [data, setData] = useState([
    ]);

    const [lastUpdate, setLastUpdate] = useState(new Date());

    useEffect(() => {
      axios
        .get("http://localhost:8080/TemplateWS/rest/ws/professores/JSON")
        .then(response => {
   
          console.log(response.data.lista);
          const alunos = response.data.lista.map(c => {
            return {
              id: c.id,
              matricula: c.matricula,
              nome: c.nome,
              idEnderedo: c.idEnderedo,
              curso: c.curso
            };
          }, [lastUpdate]);
          console.log(alunos[0]);
          setData(alunos);
        })
        .catch(error => console.log(error));
    }, [])

    function handleCreate(newData) {
      axios
        .post("http://localhost:8080/TemplateWS/rest/ws/cadastraProfessor", {
          "id": newData.id,
          "matricula": newData.matricula,
          "nome": newData.nome,
          "idEnderedo": newData.idEnderedo,
          "curso": newData.curso
        })
        .then(function(response){
          console.log('salvo com sucesso')
        });
    }

    function handleUptade(newData) {

      axios.post("http://localhost:8080/TemplateWS/rest/ws/atualizaProfessor", {
          "matricula": newData.matricula,
          "nome": newData.nome,
          "idEnderedo": newData.idEnderedo,
          "curso": newData.curso,
          "id": newData.id,
      })
      .then(function(response){
        console.log('atualizado com sucesso')
      });
    }

    
    function handleDel(oldData) {
      axios.delete("http://localhost:8080/TemplateWS/rest/ws/removeProfessor/"+oldData.id)
        .then(function(response){
         
          const dataDelete = [...data];
          const index = oldData.tableData.id;
          dataDelete.splice(index, 1);
          setData([...dataDelete]);
          setLastUpdate(new Date());
          console.log("deletado com sucesso!")
        }).catch(function (error) {
          console.log(error);
          if(error.response.status == 401)  {
            console.log("O professor está associado a um projeto!")
            alert("Não é possivel excluir pois o professor está associado a um projeto!")
          }
      });
    }


    return (
      
      <MaterialTable
        title="Gerenciamento de Professores"
        columns={columns}
        data={data}
        editable={{
          onRowAdd: newData =>
            new Promise((resolve, reject) => {
              setTimeout(() => {
                handleCreate(newData);
                setData([...data, newData]);
                
                resolve();
              }, 1000)
            }),
          onRowUpdate: (newData, oldData) =>
            new Promise((resolve, reject) => {
              setTimeout(() => {
                handleUptade(newData, oldData);
                const dataUpdate = [...data];
                const index = oldData.tableData.id;
                dataUpdate[index] = newData;
                setData([...dataUpdate]);
  
                resolve();
              }, 1000)
            }),
          onRowDelete: oldData =>
            new Promise((resolve, reject) => {
              
              setTimeout(() => {
                //console.log(oldData);
                handleDel(oldData);
                
                resolve();
              }, 1000)
            }),
        }}
      />
    )
  }

  export default GerenciamentoProfessores;