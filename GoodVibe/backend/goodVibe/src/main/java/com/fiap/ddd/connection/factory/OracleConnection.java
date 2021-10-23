package com.fiap.ddd.connection.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection implements MyConnection {

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		try {
			String connectionURL = "jdbc:oracle:thin:@localhost:1521:ORCLCDB";
			String user = "root"; //COLOCAR AQUI USUARIO
			String password = "root"; //COLOCAR AQUI SENHA
			Connection connection = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(connectionURL, user, password);
			return connection;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
