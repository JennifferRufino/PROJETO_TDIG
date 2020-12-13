package template.rest.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import template.rest.dto.Projeto;

public class ProjetoDAO {
	
	public ArrayList<Projeto> getProjetos(Connection connection) throws Exception {
		
		ArrayList<Projeto> projetos = new ArrayList<Projeto>();
		try {
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement("SELECT "
					+ "id, titulo_projeto, area_projeto, resumo, palavra_chave1, palavra_chave2,"
					+ " palavra_chave3, url, fk_professores_id,	fk_alunos_id FROM controle_academico.projeto");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Projeto projeto = new Projeto();
				projeto.setId(rs.getInt("id"));
				projeto.setTituloProjeto(rs.getString("titulo_projeto"));
				projeto.setAreaProjeto(rs.getString("area_projeto"));
				projeto.setResumo(rs.getString("resumo"));
				projeto.setPalavraChave1(rs.getString("palavra_chave1"));
				projeto.setPalavraChave2(rs.getString("palavra_chave2"));
				projeto.setPalavraChave3(rs.getString("palavra_chave3"));
				projeto.setUrl(rs.getString("url"));
				projeto.setIdProfessorResponsavel(rs.getInt("fk_professores_id"));
				projeto.setIdAlunoParticipante(rs.getInt("fk_alunos_id"));
				projetos.add(projeto);
			}
			return projetos;
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public void cadastraProjeto(Connection connection, Projeto projetoEntrada){
		
		try {
			Statement stm = (Statement) connection.createStatement();
			
			String query = "INSERT INTO controle_academico.projeto (titulo_projeto, "
					+ "area_projeto, resumo, palavra_chave1, palavra_chave2, palavra_chave3, url, fk_professores_id, fk_alunos_id ) VALUES ( '"
					+ projetoEntrada.getTituloProjeto() + "', '" 
					+ projetoEntrada.getAreaProjeto() + "', '" 
					+ projetoEntrada.getResumo() + "', '" 
					+ projetoEntrada.getPalavraChave1() + "', '" 
					+ projetoEntrada.getPalavraChave2() + "', '"
					+ projetoEntrada.getPalavraChave3() + "', '" 
					+ projetoEntrada.getUrl() + "', '" 
					+ projetoEntrada.getIdProfessorResponsavel() + "', '" 
					+ projetoEntrada.getIdAlunoParticipante()+ "');";
			stm.execute(query);
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	public void atualizaProjeto(Connection connection, Projeto projetoEntrada){
		
		try {
			Statement stm = (Statement) connection.createStatement();
			
			String query = "UPDATE controle_academico.projeto SET "
					+ "titulo_projeto='"+ projetoEntrada.getTituloProjeto() 
					+ "', area_projeto='"+ projetoEntrada.getAreaProjeto()
					+ "', resumo='"+ projetoEntrada.getResumo() 
					+ "', palavra_chave1='"+ projetoEntrada.getPalavraChave1() 
					+ "', palavra_chave2='"+ projetoEntrada.getPalavraChave2() 
					+ "', palavra_chave3='"+ projetoEntrada.getPalavraChave3() 
					+ "', url='"+ projetoEntrada.getUrl()
					+ "', fk_professores_id='"+ projetoEntrada.getIdProfessorResponsavel()
					+ "', fk_alunos_id='"+ projetoEntrada.getIdAlunoParticipante()
					+ "' where ID='" + projetoEntrada.getId() + "';";
			stm.execute(query);
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
		
	public void removeProjeto(Connection connection, Projeto projetoEntrada){
		
		try {
			Statement stm = (Statement) connection.createStatement();
			
			String query = "DELETE FROM controle_academico.projeto where ID= '"+ projetoEntrada.getId() + "';";
			stm.execute(query);
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
		
}
