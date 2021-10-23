package com.fiap.ddd.repository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fiap.ddd.dao.TemaDAO;
import com.fiap.ddd.to.TemaTO;

public class TemaRepository {
	
	public ArrayList<TemaTO> getAll() throws ClassNotFoundException, SQLException, IOException {
		ArrayList<TemaTO> listaTema = new ArrayList<TemaTO>();
		TemaDAO dao = new TemaDAO();
		listaTema = dao.getAll();
		return listaTema;
	}
	
	public TemaTO findById(int id) throws ClassNotFoundException, SQLException, IOException {
		TemaTO tema = new TemaTO();
		TemaDAO dao = new TemaDAO();
		tema = dao.getById(id);
		return tema;
	}
	
	public void delete(int id) throws ClassNotFoundException, SQLException, IOException {
		TemaDAO dao = new TemaDAO();
		dao.delete(id);
	}
	
	public void insert(TemaTO to) throws ClassNotFoundException, SQLException, IOException {
        TemaDAO dao = new TemaDAO();
        dao.insert(to);
    }

    public void update(TemaTO to) throws ClassNotFoundException, SQLException, IOException {
        TemaDAO dao = new TemaDAO();
        dao.update(to);
    }

}
