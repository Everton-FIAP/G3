package com.fiap.ddd.http.resource;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fiap.ddd.repository.PostagemRepository;
import com.fiap.ddd.to.PostagemTO;

//AQUI É ONDE DEFINIMOS OS METODOS QUE SERÃO APRESENTADOS PELO CLIENTE
@Path("/postagem")
public class PostagemResource {
	
	public PostagemRepository postagemBo = new PostagemRepository();
	
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public ArrayList<PostagemTO> getAll() throws ClassNotFoundException, SQLException, IOException {
			return postagemBo.getAll();
		}
	
		@GET
		@Path("/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public PostagemTO getById(@PathParam("id") int id) throws ClassNotFoundException, SQLException, IOException {
			return postagemBo.findById(id);
		}
	
		@DELETE
		@Path("/{id}")
		public void delete(@PathParam("id") int id) throws ClassNotFoundException, SQLException, IOException {
			postagemBo.delete(id);
		}
		
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public void insert(PostagemTO postagemTO, @PathParam("id") int id) throws ClassNotFoundException, SQLException, IOException {
			postagemBo.insert(postagemTO);
		}
		
		@PUT
		@Path("/{id}")
		@Consumes(MediaType.APPLICATION_JSON)
		public void update(PostagemTO postagemTO, @PathParam("id") int id) throws ClassNotFoundException, SQLException, IOException {
			postagemTO.setId(id);
			postagemBo.update(postagemTO);
		}

}
