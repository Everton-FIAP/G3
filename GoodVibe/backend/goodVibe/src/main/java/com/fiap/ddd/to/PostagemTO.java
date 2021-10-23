package com.fiap.ddd.to;


//AQUI SERA ONDE DEFINIMOS O MODELO DO OBJETO QUE SERÁ TRANSFERIDO DENTRO DA API
public class PostagemTO {
	private int id;
	private int idTema;
	private String titulo;
	private String descricao;
	private String link;
	private java.sql.Date dtPost;
	private TemaTO tema = new TemaTO();
	
	public PostagemTO() {}
	
	public PostagemTO(int id, String titulo, String descricao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public TemaTO getTema() {
		return tema;
	}
	
	public void setTema(TemaTO tema) {
		this.tema = tema;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	public java.sql.Date getDtPost() {
		return dtPost;
	}

	public void setDtPost(java.sql.Date dtPost) {
		this.dtPost = dtPost;
	}
	
	public int getIdTema() {
		return idTema;
	}

	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	
	
	@Override
	public String toString() {
		return "PostagemTO [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao;
	}
}
