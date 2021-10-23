package com.fiap.ddd.connection.factory;

import java.sql.Connection;
import java.sql.SQLException;

public interface MyConnection {
	Connection getConnection() throws SQLException, ClassNotFoundException;
}
