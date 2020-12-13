package template.rest.model;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import template.rest.dao.AlunoDAO;
import template.rest.dao.Database;
import template.rest.dao.UsuarioDAO;
import template.rest.dto.Aluno;
import template.rest.dto.Professor;

public class GerenciadorAlunos {
	
	Database database = new Database();
	
	public ArrayList<Aluno> getAlunos()throws Exception {
		ArrayList<Aluno> alunosTemp = new ArrayList<Aluno>();
		try {
			Connection connection = (Connection) database.getConnection();
			AlunoDAO alunoDAO = new AlunoDAO();
			alunosTemp = alunoDAO.getAlunos(connection);
			connection.close();
		}
		catch (Exception e) {
			throw e;
		}
		return alunosTemp;
	}
	
	public void cadastraAluno(Aluno alunoEntrada) {
		Connection connection = (Connection) database.getConnection();
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.cadastraAluno(connection, alunoEntrada);
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void atualizaAluno(Aluno alunoEntrada) {
		Connection connection = (Connection) database.getConnection();
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.atualizaAluno(connection, alunoEntrada);
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	public void removeAluno(Aluno alunoEntrada) throws Exception {
		Connection connection = (Connection) database.getConnection();
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.removeAluno(connection, alunoEntrada);
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	public String login(String usuario, String senha) {
		
		Connection connection = (Connection) database.getConnection();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		boolean ehAutentico = usuarioDAO.verificaAutenticidadeUsuario(connection, usuario, senha);
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return String.valueOf(ehAutentico);
		
	}
	
	public Aluno getAlunoById(int id) {
		try {
			for (Aluno a : getAlunos()) {
				if(a.getId() == id) return a;
			}
		} catch(Exception e) {
			return null;
		}
		return null;
	}
}
