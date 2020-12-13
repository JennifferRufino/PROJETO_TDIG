package template.rest.model;

import java.sql.SQLException;

import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import template.rest.dao.Database;
import template.rest.dao.ProfessorDAO;
import template.rest.dao.UsuarioDAO;
import template.rest.dto.Professor;

public class GerenciadorProfessor {
	
Database database = new Database();
	
	public ArrayList<Professor> getProfessor()throws Exception {
		ArrayList<Professor> professorTemp = new ArrayList<Professor>();
		try {
			Connection connection = (Connection) database.getConnection();
			ProfessorDAO professorDAO = new ProfessorDAO();
			professorTemp = professorDAO.getProfessor(connection);
			connection.close();
		}
		catch (Exception e) {
			throw e;
		}
		return professorTemp;
	}
	
	public void cadastraProfessor(Professor professorEntrada) {
		Connection connection = (Connection) database.getConnection();
		ProfessorDAO professorDAO = new ProfessorDAO();
		professorDAO.cadastraProfessor(connection, professorEntrada);
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizaProfessor(Professor professorEntrada) {
		Connection connection = (Connection) database.getConnection();
		ProfessorDAO professorDAO = new ProfessorDAO();
		professorDAO.atualizaProfessor(connection, professorEntrada);
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	/**
	 
	 * @param professorEntrada
	 * @throws Exception
	 */
	public void removeProfessor(Professor professorEntrada) throws Exception {
		Connection connection = (Connection) database.getConnection();
		ProfessorDAO professorDAO = new ProfessorDAO();
		professorDAO.removeProfessor(connection, professorEntrada);
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
	
	public Professor getProfessorById(int id) {
		try {
		for (Professor p : getProfessor()) {
			if(p.getId() == id) return p;
		}
		} catch(Exception e) {
			return null;
		}
		return null;
	}

}
