/*package com.fiap.ddd.to;

import java.util.Calendar;
import java.util.Date;

public class PostagemBO {
	
	private String titulo;
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getDtPost() {
		return dtPost;
	}

	public void setDtPost(Date dtPost) {
		this.dtPost = dtPost;
	}

	public TemaBO getTema() {
		return tema;
	}

	public void setTema(TemaBO tema) {
		this.tema = tema;
	}

	private String descricao;
	private String link;
	private Date dtPost = Calendar.getInstance().getTime();
	private TemaBO tema; //Chave estrangeira
	
	public PostagemBO() {}
	
	public PostagemBO(String titulo, String descricao, TemaBO tema) {
		this.titulo = titulo;
		this.descricao = descricao;
		
		if (tema == null) {
			throw new Exception();
		}
	}
	
	public boolean valido() {
		if (tema == null) {
			throw new Exception();
		}
	}
}
*/