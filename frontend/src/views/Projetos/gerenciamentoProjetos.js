import { Grid, MuiThemeProvider, Button } from '@material-ui/core';
import { createMuiTheme } from '@material-ui/core/styles';
import React, { useEffect } from "react";
import axios from 'axios';
// @material-ui/core components
import { makeStyles } from "@material-ui/core/styles";
import MaterialTable from "material-table";

const GerenciamentoProjetos = props => {
    const { useState } = React;
  
    const [columns, setColumns] = useState([
      { title: 'Id', field: 'id' },
      { title: 'Titulo do rojeto', field: 'tituloProjeto'},
      { title: 'Resumo', field: 'resumo'},
      { title: 'Palavra Chave 1', field: 'palavraChave1' },
      { title: 'Palavra Chave 2', field: 'palavraChave2' },
      { title: 'Palavra Chave 3', field: 'palavraChave3' },
      { title: 'url', field: 'url' },
      { title: 'Id Professor Responsavel', field: 'idProfessorResponsavel', type: 'numerico' },
      { title: 'Id Aluno Participante', field: 'idAlunoParticipante', type: 'numerico' },
      
    ]);
  
    const [data, setData] = useState([
    ]);

    useEffect(() => {
      axios
        .get("http://localhost:8080/TemplateWS/rest/ws/projetos/JSON")
        .then(response => {
   
          // create an array of contacts only with relevant data
          console.log(response.data.lista);
          const alunos = response.data.lista.map(c => {
            return {
              id: c.id,
              tituloProjeto: c.tituloProjeto,
              resumo: c.resumo,
              palavraChave1: c.palavraChave1,
              palavraChave2: c.palavraChave2,
              palavraChave3: c.palavraChave3,
              url: c.url,
              idProfessorResponsavel: c.idProfessorResponsavel,
              idAlunoParticipante: c.idAlunoParticipante
            };
          });
    
          console.log(alunos[0]);
          setData(alunos);
        })
        .catch(error => console.log(error));
    }, [])

    function handleCreate(newData) {
      axios
        .post("http://localhost:8080/TemplateWS/rest/ws/cadastraProjeto", {
          "id": newData.id,
          "tituloProjeto": newData.tituloProjeto,
          "resumo": newData.resumo,
          "palavraChave1": newData.palavraChave1,
          "palavraChave2": newData.palavraChave2,
          "palavraChave3": newData.palavraChave3,
          "url": newData.url,
          "idProfessorResponsavel": newData.idProfessorResponsavel,
          "idAlunoParticipante": newData.idAlunoParticipante
        })
        .then(function(response){
          console.log('salvo com sucesso')
        });
    }

    function handleDel(newData) {
      axios.delete("http://localhost:8080/TemplateWS/rest/ws/removeProjeto/" + newData.id)
        .then(function(response){
          console.log('Deletado com sucesso')
        });
    }

    function handleUptade(newData) {

      axios.post("http://localhost:8080/TemplateWS/rest/ws/atualizaProjeto", {
        "id": newData.id,
        "tituloProjeto": newData.tituloProjeto,
        "resumo": newData.resumo,
        "palavraChave1": newData.palavraChave1,
        "palavraChave2": newData.palavraChave2,
        "palavraChave3": newData.palavraChave3,
        "url": newData.url,
        "idProfessorResponsavel": newData.idProfessorResponsavel,
        "idAlunoParticipante": newData.idAlunoParticipante
      })
      .then(function(response){
        console.log('atualizado com sucesso')
      });
    }


    return (
      
      <MaterialTable
        title="Gerenciamento de Projetos"
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
                const dataDelete = [...data];
                const index = oldData.tableData.id;
                dataDelete.splice(index, 1);
                setData([...dataDelete]);
               
                
                resolve();
              }, 1000)
            }),
        }}
      />
    )
  }

  export default GerenciamentoProjetos;