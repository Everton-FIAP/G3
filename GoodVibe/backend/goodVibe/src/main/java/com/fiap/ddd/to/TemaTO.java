package com.fiap.ddd.to;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TemaTO {

	private int idTema;
	private String tituloTema;
	private String dsTema;
	private ArrayList<PostagemTO> postagens = new ArrayList<PostagemTO>(); //Chave estrangeira
	
	public TemaTO() {
							
	}
	
	public TemaTO(int idTema, String tituloTema, String dsTema) {
		this.idTema = idTema;
		this.tituloTema = tituloTema;
		this.dsTema = dsTema;
	}
	
	public ArrayList<PostagemTO> getPostagens() {
		return postagens;
	}
	
	public int getIdTema() {
		return idTema;
	}
	
	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	
	public String getTituloTema() {
		return tituloTema;
	}
	
	public void setTituloTema(String tituloTema) {
		this.tituloTema = tituloTema;
	}
	
	public String getDsTema() {
		return dsTema;
	}
	
	public void setDsTema(String dsTema) {
		this.dsTema = dsTema;
	}
	
}
