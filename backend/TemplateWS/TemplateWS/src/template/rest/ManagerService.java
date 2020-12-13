package template.rest;

import java.lang.System.Logger;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import java.util.*;

import org.glassfish.jersey.media.multipart.MultiPart;

import com.sun.tools.javac.util.Log;

import template.rest.dto.Aluno;
import template.rest.dto.Endereco;
import template.rest.dto.Professor;
import template.rest.dto.Projeto;
import template.rest.model.GerenciadorAlunos;
import template.rest.model.GerenciadorEndereco;
import template.rest.model.GerenciadorProfessor;
import template.rest.model.GerenciadorProjetos;

@Path("/ws")
public class ManagerService {
	
	GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();
	GerenciadorProfessor gerenciadorProfessor = new GerenciadorProfessor();
	GerenciadorProjetos gerenciadorProjeto = new GerenciadorProjetos();
	GerenciadorEndereco gerenciadorEndereco = new GerenciadorEndereco();
		
	@GET
	@Path("/alunos/XML")
	@Produces(MediaType.APPLICATION_XML)
	public ResponseList getAlunosXML() {
		
		ResponseList listaAlunos = new ResponseList();
		try {
			listaAlunos.setLista(gerenciadorAlunos.getAlunos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaAlunos;
	}
	
	@GET
	@Path("/alunos/JSON")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseList getAlunosJSON() {
		
		ResponseList listaAlunos = new ResponseList();
		try {
			listaAlunos.setLista(gerenciadorAlunos.getAlunos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaAlunos;
	}
	
	@POST
	@Path("/cadastraAluno")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response CadastrarAluno(Aluno alunoEntrada){
		gerenciadorAlunos.cadastraAluno(alunoEntrada);
		String result = "Aluno" + alunoEntrada.getNome() + "e matricula" + alunoEntrada.getMatricula() + "foi cadastrado com sucesso";
		return Response.status(201).entity(result).build();
	}
	
	@POST
	@Path("/atualizaAluno")
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizaAluno(Aluno alunoEntrada){
		gerenciadorAlunos.atualizaAluno(alunoEntrada);
		String result = "Aluno " + alunoEntrada.getNome() + " e matricula" + alunoEntrada.getMatricula() + " foi atualizado com sucesso";
		return Response.status(200).entity(result).build();
	}
	
	@DELETE
	@Path("/removeAluno/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response removeAluno(@PathParam("id") int id){ //----
		Aluno aluno = gerenciadorAlunos.getAlunoById(id);//----
		
		if (aluno != null) {
			try {
				gerenciadorAlunos.removeAluno(aluno);
				String result = "Professor" + aluno.getNome() + "e matricula" + aluno.getMatricula() + "foi removido com sucesso";
				return Response.status(200).entity(result).build();
			} catch (Exception e) {
				
				return Response.status(401)
						.entity("Houve um problema ao tentar remover o aluno, verifique se ele está associado a algum projeto antes de remover ou se estamos passando por problemas de conexão!")
						.build();			}
		} 

		String result = "Não foi encontrado um aluno com esse id!";
		return Response.status(404).entity(result).build();
	}
	
	// Professores
	
	@GET
	@Path("/professores/XML")
	@Produces(MediaType.APPLICATION_XML)
	public ResponseListProfessor getProfessorXML() {
		
		ResponseListProfessor listaProfessor = new ResponseListProfessor();
		try {
			listaProfessor.setLista(gerenciadorProfessor.getProfessor());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaProfessor;
	}
	
	@GET
	@Path("/professores/JSON")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseListProfessor getProfessorJSON() {
		
		ResponseListProfessor listaProfessor = new ResponseListProfessor();
		try {
			listaProfessor.setLista(gerenciadorProfessor.getProfessor());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaProfessor;
	}
	
	@POST
	@Path("/cadastraProfessor")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response CadastrarProfessor(Professor professorEntrada){
		gerenciadorProfessor.cadastraProfessor(professorEntrada);
		String result = "Professor" + professorEntrada.getNome() + "e matricula" + professorEntrada.getMatricula() + "foi cadastrado com sucesso";
		return Response.status(201).entity(result).build();
	}
	
	@POST
	@Path("/atualizaProfessor")
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizaProfessor(Professor professorEntrada){
		gerenciadorProfessor.atualizaProfessor(professorEntrada);
		String result = "Professor " + professorEntrada.getNome() + " e matricula" + professorEntrada.getMatricula() + " foi atualizado com sucesso";
		return Response.status(200).entity(result).build();
	}
	
	
	@DELETE
	@Path("/removeProfessor/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response removeProfessor(@PathParam("id") int id){ //----
		Professor professor = gerenciadorProfessor.getProfessorById(id);//----
	
		if (professor != null) {
			try {
				gerenciadorProfessor.removeProfessor(professor);
				String result = "Professor" + professor.getNome() + "e matricula" + professor.getMatricula() + "foi removido com sucesso";
				return Response.status(200).entity(result).build();
			} catch (Exception e) {
				return Response.status(401)
						.entity("Houve um problema ao tentar remover o professor, verifique se ele está associado a algum projeto antes de remover ou se estamos passando por problemas de conexão!")
						.build();			}
		} 

		String result = "Não foi encontrado um professor com esse id!";
		return Response.status(404).entity(result).build();
	}
	
	// Projetos
	
	@GET
	@Path("/projetos/XML")
	@Produces(MediaType.APPLICATION_XML)
	public ResponseListProjeto getProjetoXML() {
		
		ResponseListProjeto listaProjeto = new ResponseListProjeto();
		try {
			listaProjeto.setLista(gerenciadorProjeto.getProjetos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaProjeto;
	}
	
	@GET
	@Path("/projetos/JSON")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseListProjeto getProjetoJSON() {
		
		ResponseListProjeto listaProjeto = new ResponseListProjeto();
		try {
			listaProjeto.setLista(gerenciadorProjeto.getProjetos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaProjeto;
	}
	
	@POST
	@Path("/cadastraProjeto")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response CadastrarProjeto(Projeto projetoEntrada){
		gerenciadorProjeto.cadastraProjeto(projetoEntrada);
		String result = "Projeto" + projetoEntrada.getTituloProjeto() + "e resumo" + projetoEntrada.getResumo() + "foi cadastrado com sucesso";
		return Response.status(201).entity(result).build();
	}
	
	@POST
	@Path("/atualizaProjeto")
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizaProjeto(Projeto projetoEntrada){
		gerenciadorProjeto.atualizaProjeto(projetoEntrada);
		String result = "Projeto " + projetoEntrada.getTituloProjeto() + " e resumo" + projetoEntrada.getResumo() + " foi atualizado com sucesso";
		return Response.status(200).entity(result).build();
	}
	
	@DELETE
	@Path("/removeProjeto/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response removeProjeto(@PathParam("id") int id){ //----
		Projeto projeto = gerenciadorProjeto.getProjetoById(id);//----
	
		if (projeto != null) {
			try {
				gerenciadorProjeto.removeProjeto(projeto);
				String result = "Projeto" + projeto.getTituloProjeto() + "e resumo" + projeto.getResumo() + "foi removido com sucesso";
				return Response.status(200).entity(result).build();
			} catch (Exception e) {
				return Response.status(401)
						.entity("Houve um problema ao tentar remover o projeto, verifique se ele está associado a algum projeto antes de remover ou se estamos passando por problemas de conexão!")
						.build();			}
		} 

		String result = "Não foi encontrado um projeto com esse id!";
		return Response.status(404).entity(result).build();
	}
	
	
	// Endereços
	
	@GET
	@Path("/enderecos/XML")
	@Produces(MediaType.APPLICATION_XML)
	public ResponseListEndereco getEnderecoXML() {
		
		ResponseListEndereco listaEndereco = new ResponseListEndereco();
		try {
			listaEndereco.setLista(gerenciadorEndereco.getEnderecos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaEndereco;
	}
	
	@GET
	@Path("/enderecos/JSON")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseListEndereco getEnderecoJSON() {
		
		ResponseListEndereco listaEndereco = new ResponseListEndereco();
		try {
			listaEndereco.setLista(gerenciadorEndereco.getEnderecos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaEndereco;
	}
	
	@POST
	@Path("/cadastraEndereco")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response CadastrarEndereco(Endereco enderecoEntrada){
		gerenciadorEndereco.cadastraEndereco(enderecoEntrada);
		String result = "Endereço" + enderecoEntrada.getRua() + "foi cadastrado com sucesso";
		return Response.status(201).entity(result).build();
	}
	
	@POST
	@Path("/atualizaEndereco")
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizaEndereco(Endereco enderecoEntrada){
		gerenciadorEndereco.atualizaEndereco(enderecoEntrada);
		String result = "Endereço " + enderecoEntrada.getRua() + " foi atualizado com sucesso";
		return Response.status(200).entity(result).build();
	}
	
	@DELETE
	@Path("/removeEndereco")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response removeEndereco(Endereco enderecoEntrada){
		gerenciadorEndereco.removeEndereco(enderecoEntrada);
		String result = "Endereço" + enderecoEntrada.getRua() + "foi removido com sucesso";
		return Response.status(200).entity(result).build();
	}

	@POST
	@Path("/login")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	public String login(MultiPart data) {
		return gerenciadorAlunos.login(data.getBodyParts().get(0).getEntityAs(String.class), data.getBodyParts().get(1).getEntityAs(String.class));
	}
	
	

}