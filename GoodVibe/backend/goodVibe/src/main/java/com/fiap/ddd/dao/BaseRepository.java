package com.fiap.ddd.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BaseRepository<T> {
	public void insert(T t) throws SQLException;
	public void update(T t) throws SQLException;
	public void delete(int id) throws SQLException;
	public T getById(int id) throws SQLException;
	public ArrayList<T> getAll() throws SQLException;
}
