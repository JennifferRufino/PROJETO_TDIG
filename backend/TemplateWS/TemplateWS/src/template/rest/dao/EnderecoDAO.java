package template.rest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.sun.java.browser.plugin2.liveconnect.v1.Result;

import template.rest.dto.Endereco;

public class EnderecoDAO {
	
	public ArrayList<Endereco> getEnderecos(Connection connection) throws Exception {
		
		ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
		try {
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement("SELECT "
					+ "id, rua, numero, cep, cidade, estado, pais FROM controle_academico.endereco");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Endereco endereco = new Endereco();
				endereco.setId(rs.getInt("id"));
				endereco.setRua(rs.getString("rua"));
				endereco.setNumero(rs.getString("numero"));
				endereco.setCep(rs.getString("cep"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setPais(rs.getString("pais"));
				enderecos.add(endereco);
			}
			return enderecos;
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public void cadastraEndereco(Connection connection, Endereco enderecoEntrada){
		
		try {
			Statement stm = (Statement) connection.createStatement();
			
			String query = "INSERT INTO controle_academico.endereco (rua, numero, cep, cidade, estado, pais) VALUES ( '"
					+ enderecoEntrada.getRua() + "', '" 
					+ enderecoEntrada.getNumero() + "', '" 
					+ enderecoEntrada.getCep() + "', '" 
					+ enderecoEntrada.getCidade() + "', '" 
					+ enderecoEntrada.getEstado() + "', '"
					+ enderecoEntrada.getPais() + "');";
			
			int affectedRows = stm.executeUpdate(query);

	        if (affectedRows == 0) {
	            throw new SQLException("Creating user failed, no rows affected.");
	        }

	        try (ResultSet generatedKeys = stm.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	            	enderecoEntrada.setId(generatedKeys.getInt(1));
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	public void atualizaEndereco(Connection connection, Endereco enderecoEntrada){
		
		try {
			Statement stm = (Statement) connection.createStatement();
			
			String query = "UPDATE controle_academico.endereco SET "
					+ "rua='"+ enderecoEntrada.getRua() 
					+ "', numero='"+ enderecoEntrada.getNumero()
					+ "', cep='"+ enderecoEntrada.getCep() 
					+ "', cidade='"+ enderecoEntrada.getCidade()
					+ "', estado='"+ enderecoEntrada.getEstado() 
					+ "', pais='"+ enderecoEntrada.getPais() 
					+ "' where ID='" + enderecoEntrada.getId() + "';";
			stm.execute(query);
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
		
	public void removeEndereco(Connection connection, Endereco enderecoEntrada){
		
		try {
			Statement stm = (Statement) connection.createStatement();
			
			String query = "DELETE FROM controle_academico.endereco where ID= '"+ enderecoEntrada.getId() + "';";
			stm.execute(query);
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
		
}
