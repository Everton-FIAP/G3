package com.fiap.ddd.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fiap.ddd.connection.factory.ConnectionFactory;
import com.fiap.ddd.connection.factory.Database;
import com.fiap.ddd.to.PostagemTO;
import com.fiap.ddd.to.TemaTO;

//AQUI ONDE DEFINIMOS AS QUERYS QUE SERÃO REALIZADAS NO BANCO DE DADOS UTILIZANDO O BO
public class PostagemDAO implements BaseRepository<PostagemTO> {

	private Connection con;
	ConnectionFactory db = new ConnectionFactory();

	public PostagemDAO() throws ClassNotFoundException, SQLException, IOException {
		this.con = db.getConnection(Database.MYSQL);
	}

	@Override
	public void insert(PostagemTO t) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("insert into gv_postagem(titulo_post, ds_post, link_post, dt_post, id_tema) values(?,?,?,?,?)");
		java.sql.Date dtPost = new java.sql.Date(System.currentTimeMillis());
		stmt.setString(1, t.getTitulo());
		stmt.setString(2, t.getDescricao());
		stmt.setString(3, t.getLink());
		stmt.setDate(4, dtPost);
		stmt.setInt(5, t.getIdTema());
		
		stmt.execute();
		this.desconnect();
	}

	@Override
	public void update(PostagemTO t) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("update gv_postagem set titulo_post = ?, ds_post = ?, dt_post = ?, link_post = ? where id_post = ?");
		java.sql.Date dtPost = new java.sql.Date(System.currentTimeMillis());
		stmt.setString(1, t.getTitulo());
		stmt.setString(2, t.getDescricao());
		stmt.setDate(3, dtPost);
		stmt.setString(4, t.getLink());
		stmt.setInt(5, t.getId());

		stmt.executeUpdate();
		this.desconnect();
	}

	@Override
	public void delete(int id) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("delete from gv_postagem where id_post = ?");
		stmt.setInt(1, id);
		stmt.executeUpdate();
		this.desconnect();
	}

	@Override
	public PostagemTO getById(int id) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("select * from gv_postagem where id_post = ?");
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();

		try {
			if(rs.next()) {
				PostagemTO postagem = new PostagemTO();
				postagem.setId(rs.getInt("id_post"));
				postagem.setTitulo(rs.getString("titulo_post"));
				postagem.setDescricao(rs.getString("ds_post"));

				this.desconnect();
				return postagem;
			}
		}catch(Exception e) {
			throw e;
		}
		return null;
	}

	@Override
	public ArrayList<PostagemTO> getAll() throws SQLException {
		ArrayList<PostagemTO> postagemList = new ArrayList<PostagemTO>();
		
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM gv_postagem");
		
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()) {
				PostagemTO postagem = new PostagemTO();
				
				postagem.setId(rs.getInt("id_post"));
				postagem.setTitulo(rs.getString("titulo_post"));	
				postagem.setDescricao(rs.getString("ds_post"));
				postagem.setDtPost(rs.getDate("dt_post"));
				postagem.setLink(rs.getString("link_post"));
				postagem.setIdTema(rs.getInt("id_tema"));
				
				PreparedStatement tem = con.prepareStatement("SELECT y.*, x.* FROM gv_tema x INNER JOIN gv_postagem y on x.id_tema = y.id_tema;");
				ResultSet ss = tem.executeQuery();
				
					while(ss.next()) {
						TemaTO tema = new TemaTO();
						tema.setIdTema(ss.getInt("id_tema"));
						if(tema.getIdTema() == postagem.getIdTema()) {
							tema.setTituloTema(ss.getString("titulo_tema"));
							tema.setDsTema(ss.getString("ds_tema"));
							postagem.setTema(tema);
							break;
						
						}else {
							postagem.setTema(null);
						}
					}
					
				postagemList.add(postagem);
			}
		}catch(Exception e) {
			throw e;
		}

		this.desconnect();
		return postagemList;
	}

	private void desconnect() throws SQLException {
		if (!this.con.isClosed()) {
			this.con.close();
		}
	}

}
