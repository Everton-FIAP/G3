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

import com.fiap.ddd.repository.TemaRepository;
import com.fiap.ddd.to.TemaTO;

@Path("/tema")
public class TemaResource {
	
	public TemaRepository temaRepository = new TemaRepository();
	
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public ArrayList<TemaTO> getAll() throws ClassNotFoundException, SQLException, IOException {
			return temaRepository.getAll();
		}
		
		@GET
		@Path("/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public TemaTO getById(@PathParam("id") int id) throws ClassNotFoundException, SQLException, IOException {
			return temaRepository.findById(id);
		}
		
		@DELETE
		@Path("/{id}")
		public void delete(@PathParam("id") int id) throws ClassNotFoundException, SQLException, IOException {
			temaRepository.delete(id);
		}
		
		@POST
        @Consumes(MediaType.APPLICATION_JSON)
        public void insert(TemaTO temaTO, @PathParam("id") int id) throws ClassNotFoundException, SQLException, IOException {
            temaRepository.insert(temaTO);
        }

        @PUT
        @Path("/{id}")
        @Consumes(MediaType.APPLICATION_JSON)
        public void update(TemaTO temaTO, @PathParam("id") int id) throws ClassNotFoundException, SQLException, IOException {
            temaTO.setIdTema(id);
            temaRepository.update(temaTO);
        }
		
	
}
