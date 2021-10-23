package com.fiap.ddd.dao;

import java.io.IOException;
//import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fiap.ddd.connection.factory.ConnectionFactory;
import com.fiap.ddd.connection.factory.Database;
import com.fiap.ddd.to.PostagemTO;
//import com.fiap.ddd.connection.factory.Database;
import com.fiap.ddd.to.TemaTO;

public class TemaDAO implements BaseRepository<TemaTO> {

	private Connection con;
	ConnectionFactory db = new ConnectionFactory();

	public TemaDAO() throws ClassNotFoundException, SQLException, IOException {
		this.con = db.getConnection(Database.MYSQL);
	}

	@Override
	public void insert(TemaTO t) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("insert into gv_tema(titulo_tema, ds_tema) values(?,?)");
		stmt.setString(1, t.getTituloTema());
		stmt.setString(2, t.getDsTema());

		stmt.execute();
		this.desconnect();
	}

	@Override
	public void update(TemaTO t) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("update gv_tema set titulo_tema = ?, ds_tema = ? where id_tema = ?");
		stmt.setString(1, t.getTituloTema());
		stmt.setString(2, t.getDsTema());
		stmt.setInt(3, t.getIdTema());

		stmt.executeUpdate();
		this.desconnect();
	}

	@Override
	public void delete(int id) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("delete from gv_tema where id_tema = ?");
		stmt.setInt(1, id);
		stmt.executeUpdate();
		this.desconnect();
	}

	@Override
	public TemaTO getById(int id) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("select * from gv_tema where id_tema = ?");
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();

		try {
			if(rs.next()) {
				TemaTO tema = new TemaTO();
				tema.setIdTema(rs.getInt("id_tema"));
				tema.setTituloTema(rs.getString("titulo_tema"));
				tema.setDsTema(rs.getString("ds_tema"));

				this.desconnect();
				return tema;
			}
		}catch(Exception e) {
			throw e;
		}
		return null;
	}

	@Override
    public ArrayList<TemaTO> getAll() throws SQLException {
        ArrayList<TemaTO> temaList = new ArrayList<TemaTO>();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM gv_tema");
        PreparedStatement post = con.prepareStatement("SELECT * FROM gv_postagem where id_tema = ?");
        ResultSet rs = stmt.executeQuery();
        try {
            while(rs.next()) {
                TemaTO tema = new TemaTO();
                tema.setIdTema(rs.getInt("id_tema"));
                tema.setTituloTema(rs.getString("titulo_tema"));
                tema.setDsTema(rs.getString("ds_tema"));
                post.setInt(1, tema.getIdTema());
                ResultSet ss = post.executeQuery();
                    while(ss.next()) {
                        PostagemTO postagem = new PostagemTO();
                        tema.getPostagens().add(postagem);
                        postagem.setId(ss.getInt("id_post"));
                        postagem.setTitulo(ss.getString("titulo_post"));
                        postagem.setDescricao(ss.getString("ds_post"));
                        postagem.setDtPost(ss.getDate("dt_post"));
        				postagem.setLink(ss.getString("link_post"));
        				postagem.setTema(null);

                    }
                temaList.add(tema);
            }
        }catch(Exception e) {
            throw e;
        }

        this.desconnect();
        return temaList;
    }


	private void desconnect() throws SQLException {
		if (!this.con.isClosed()) {
			this.con.close();
		}
	}

}
