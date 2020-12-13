package template.rest.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	
	private Connection connection = null;
	
	public Connection getConnection() {
		try {
			String connectionURL = "jdbc:mysql://localhost:3306/controle_academico?useUnicode=true&characterEncoding=utf-8";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "root", "");
		} catch (Exception e) {
			e.getStackTrace();
		}	
		return connection;
	}
	
}
