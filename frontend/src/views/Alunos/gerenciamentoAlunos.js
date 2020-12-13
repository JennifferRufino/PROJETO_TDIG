import { Grid, MuiThemeProvider, Button } from '@material-ui/core';
import { createMuiTheme } from '@material-ui/core/styles';
import React, { useEffect } from "react";
import axios from 'axios';
// @material-ui/core components
import { makeStyles } from "@material-ui/core/styles";
import MaterialTable from "material-table";

const GerenciamentoAlunos = props => {
    const { useState } = React;
  
    const [columns, setColumns] = useState([
      { title: 'Id', field: 'id'},
      { title: 'cpf', field: 'cpf'},
      { title: 'matricula', field: 'matricula'},
      { title: 'nome', field: 'nome' },
      { title: 'endereco', field: 'idEndereco', type: 'numerico' },
      { title: 'curso', field: 'curso' }
    ]);
  
    const [data, setData] = useState([
    ]);

    const [lastUpdate, setLastUpdate] = useState(new Date());


    useEffect(() => {
      axios
        .get("http://localhost:8080/TemplateWS/rest/ws/alunos/JSON")
        .then(response => {
   
          // create an array of contacts only with relevant data
          console.log(response.data.lista);
          const alunos = response.data.lista.map(c => {
            return {
              id: c.id,
              cpf: c.cpf,
              matricula: c.matricula,
              nome: c.nome,
              idEndereco: c.idEndereco,
              curso: c.curso
            };
          },[lastUpdate]);
          //console.log(alunos[0]);
          setData(alunos);
        })
        .catch(error => console.log(error));
    }, [])

    function handleCreate(newData) {
      axios
        .post("http://localhost:8080/TemplateWS/rest/ws/cadastraAluno", {
          "id": newData.id,
          "cpf": newData.cpf,
          "matricula": newData.matricula,
          "nome": newData.nome,
          "idEndereco": newData.idEndereco,
          "curso": newData.curso
        })
        .then(function(response){
          console.log('salvo com sucesso')
          window.location.reload();
        })
        .catch(function(error) {
          console.log(error.response);
        })
    }

    function handleDel(oldData) {
      axios.delete("http://localhost:8080/TemplateWS/rest/ws/removeAluno/"+oldData.id)
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
            console.log("O aluno está associado a um projeto!")
            alert("Não é possivel excluir pois o aluno está associado a um projeto!")
          }
      });
    }

    function handleUptade(newData) {

      axios.post("http://localhost:8080/TemplateWS/rest/ws/atualizaAluno", {
          "matricula": newData.matricula,
          "nome": newData.nome,
          "cpf": newData.cpf,
          "idEndereco": newData.idEndereco,
          "curso": newData.curso,
          "id": newData.id,
      })
      .then(function(response){
        console.log('atualizado com sucesso')
      });
    }


    return (
      //<Button id = "aew" color="primary" onClick={handleClick}>Consulta</Button>,
      <MaterialTable
        title="Gerenciamento de Alunos"
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
                handleUptade(newData, oldData)
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
               
                handleDel(oldData);
                resolve();
              }, 1000)
            }),
        }}
      />
    )
  }

  export default GerenciamentoAlunos;