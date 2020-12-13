package template.rest.dao;

import java.sql.ResultSet;

import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import template.rest.dto.Aluno;

public class AlunoDAO {
	
	public ArrayList<Aluno> getAlunos(Connection connection) throws Exception {
		
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		try {
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement("SELECT id, matricula, nome, cpf, fk_endereco_id, curso FROM controle_academico.aluno");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(rs.getInt("id"));
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setIdEndereco(rs.getInt("fk_endereco_id"));
				aluno.setCurso(rs.getString("curso"));
				alunos.add(aluno);
			}
			return alunos;
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public void cadastraAluno(Connection connection, Aluno alunoEntrada){
		
		try {
			Statement stm = (Statement) connection.createStatement();
			
			String query = "INSERT INTO controle_academico.aluno ( matricula, nome, cpf, fk_endereco_id, curso) VALUES ( '"
					
					+ alunoEntrada.getMatricula() + "', '" 
					+ alunoEntrada.getNome() + "', '" 
					+ alunoEntrada.getCpf() + "', '" 
					+ alunoEntrada.getIdEndereco() + "', '" 
					+ alunoEntrada.getCurso() + "');";
			stm.execute(query);
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	public void atualizaAluno(Connection connection, Aluno alunoEntrada){
		
		try {
			Statement stm = (Statement) connection.createStatement();
			
			String query = "UPDATE controle_academico.aluno SET "
					+ "matricula = '" + alunoEntrada.getMatricula() 
					+ "', nome ='"+ alunoEntrada.getNome() 
					+ "', cpf ='"+ alunoEntrada.getCpf() 
					+ "', fk_endereco_id ='"+ alunoEntrada.getIdEndereco()
					+ "', curso ='"+ alunoEntrada.getCurso()
					+ "' where ID='" + alunoEntrada.getId() + "';";
			stm.execute(query);
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	public void removeAluno(Connection connection, Aluno alunoEntrada) throws Exception{
		
		
			Statement stm = (Statement) connection.createStatement();
			
			String query = "DELETE FROM controle_academico.aluno where ID= '"+ alunoEntrada.getId() + "';";
			stm.execute(query);
		
	}
}

