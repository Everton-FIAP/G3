package com.fiap.ddd.repository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fiap.ddd.dao.PostagemDAO;
import com.fiap.ddd.to.PostagemTO;

//AQUI RECEBEMOS OS METODOS DO DAO E APLICAMOS NOSSAS REGRAS DE NEGOCIOS --> Exceptions e etc.
public class PostagemRepository {
	
	public ArrayList<PostagemTO> getAll() throws ClassNotFoundException, SQLException, IOException {
		ArrayList<PostagemTO> listaPostagem = new ArrayList<PostagemTO>();
		PostagemDAO dao = new PostagemDAO();
		listaPostagem = dao.getAll();
		return listaPostagem;
		
	}
	
	public PostagemTO findById(int id) throws ClassNotFoundException, SQLException, IOException {
		PostagemTO postagem = new PostagemTO();
		PostagemDAO dao = new PostagemDAO();
		postagem = dao.getById(id);
		return postagem;
	}
	
	public void delete(int id) throws ClassNotFoundException, SQLException, IOException {
		PostagemDAO dao = new PostagemDAO();
		dao.delete(id);
	}
	
	public void insert(PostagemTO to) throws ClassNotFoundException, SQLException, IOException {
		PostagemDAO dao = new PostagemDAO();
		dao.insert(to);
	}
	
	public void update(PostagemTO to) throws ClassNotFoundException, SQLException, IOException {
		PostagemDAO dao = new PostagemDAO();
		dao.update(to);
	}

}
