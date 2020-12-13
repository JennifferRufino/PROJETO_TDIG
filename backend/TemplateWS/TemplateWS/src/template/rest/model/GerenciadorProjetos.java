package template.rest.model;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import template.rest.dao.Database;
import template.rest.dao.ProjetoDAO;
import template.rest.dao.UsuarioDAO;
import template.rest.dto.Professor;
import template.rest.dto.Projeto;

public class GerenciadorProjetos {
	
	Database database = new Database();
	
	public ArrayList<Projeto> getProjetos()throws Exception {
		ArrayList<Projeto> projetosTemp = new ArrayList<Projeto>();
		try {
			Connection connection = (Connection) database.getConnection();
			ProjetoDAO projetoDAO = new ProjetoDAO();
			projetosTemp = projetoDAO.getProjetos(connection);
			connection.close();
		}
		catch (Exception e) {
			throw e;
		}
		return projetosTemp;
	}
	
	public void cadastraProjeto(Projeto projetoEntrada) {
		Connection connection = (Connection) database.getConnection();
		ProjetoDAO projetoDAO = new ProjetoDAO();
		projetoDAO.cadastraProjeto(connection, projetoEntrada);
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizaProjeto(Projeto projetoEntrada) {
		Connection connection = (Connection) database.getConnection();
		ProjetoDAO projetoDAO = new ProjetoDAO();
		projetoDAO.atualizaProjeto(connection, projetoEntrada);
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	public void removeProjeto(Projeto projetoEntrada) throws Exception {
		Connection connection = (Connection) database.getConnection();
		ProjetoDAO projetoDAO = new ProjetoDAO();
		projetoDAO.removeProjeto(connection, projetoEntrada);
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
	
	public Projeto getProjetoById(int id) {
		try {
		for (Projeto p : getProjetos()) {
			if(p.getId() == id) return p;
		}
		} catch(Exception e) {
			return null;
		}
		return null;
	}

	
}
