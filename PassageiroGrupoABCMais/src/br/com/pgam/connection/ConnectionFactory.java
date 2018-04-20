package br.com.pgam.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {


	public Connection getConnection() {
		
		// Conexão é feita pelo persistence.xml na pasta src/META-INF/
		 
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try {
			return DriverManager.getConnection("jdbc:mysql://10.9.0.16/test", "root", "abctur");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
