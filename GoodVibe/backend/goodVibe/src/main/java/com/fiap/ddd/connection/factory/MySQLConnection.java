package com.fiap.ddd.connection.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection implements MyConnection {

	@Override
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		try {
			String connectionURL = "jdbc:mysql://localhost/goodvibe?createDatabaseIfNotExist=true&serverTimezone=UTC&useSSl=false";
			String user = "root"; //COLOCAR USUARIO
			String password = "976449512Abc%"; //COLOCAR SENHA
			Connection connection = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(connectionURL, user, password);
			return connection;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
