package br.com.ifg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() throws ClassNotFoundException {
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost/instituicao";
			String user = "postgres";
			String password = "postgres";
			System.out.println("Conectado ao banco!");
			return DriverManager.getConnection(url, user, password);
			
			
		} catch (SQLException e) {
			throw  new RuntimeException(e);
		}
	}

}
