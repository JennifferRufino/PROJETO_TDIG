package template.rest.model;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import template.rest.dao.Database;
import template.rest.dao.EnderecoDAO;
import template.rest.dao.UsuarioDAO;
import template.rest.dto.Endereco;

public class GerenciadorEndereco {
	
	Database database = new Database();
	
	public ArrayList<Endereco> getEnderecos()throws Exception {
		ArrayList<Endereco> enderecosTemp = new ArrayList<Endereco>();
		try {
			Connection connection = (Connection) database.getConnection();
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			enderecosTemp = enderecoDAO.getEnderecos(connection);
			connection.close();
		}
		catch (Exception e) {
			throw e;
		}
		return enderecosTemp;
	}
	
	public void cadastraEndereco(Endereco enderecoEntrada) {
		Connection connection = (Connection) database.getConnection();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		enderecoDAO.cadastraEndereco(connection, enderecoEntrada);
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void atualizaEndereco(Endereco enderecoEntrada) {
		Connection connection = (Connection) database.getConnection();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		enderecoDAO.atualizaEndereco(connection, enderecoEntrada);
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	public void removeEndereco(Endereco enderecoEntrada) {
		Connection connection = (Connection) database.getConnection();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		enderecoDAO.removeEndereco(connection, enderecoEntrada);
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
	
}
