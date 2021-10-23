package com.fiap.ddd.connection.factory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection(Database database) throws ClassNotFoundException, SQLException, IOException {
		if(database == Database.ORACLE) return new OracleConnection().getConnection();
		if(database == Database.MYSQL) return new MySQLConnection().getConnection();
		if(database == Database.MONGO_DB) return null;
		return null;
	}
}
