package template.rest.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsuarioDAO {
		
	public boolean verificaAutenticidadeUsuario(Connection connection, String login, String senha) {
		try {
			Statement stm = connection.createStatement();
			String query = "SELECT * FROM controle_academico.usuario "
					+ "WHERE login = '" + login + "' AND "
					+ "senha = '" + senha + "' AND "
					+ "nivel = 2;";
			ResultSet res = stm.executeQuery(query);
			if (res.next()) return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}	
		return false;
	}
	
}

