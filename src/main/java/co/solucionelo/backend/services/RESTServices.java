package co.solucionelo.backend.services;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.solucionelo.backend.dataAccess.ServicesDataAccess;
import co.solucionelo.backend.model.Service;

@Path("/services")
public class RESTServices extends RESTService {

	@OPTIONS
	@Path("/")
	public Response doOptions() {
		processResponse();
		return Response.ok().build();
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Service> listServices() throws URISyntaxException, SQLException {
		List<Service> list = new ArrayList<Service>();

				
		//TODO DataAccess
		list = ServicesDataAccess.listAll();
		processResponse();
		return list;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON ) 
	public Service getService(@PathParam("id") int id) throws URISyntaxException, SQLException {
		Service service = new Service();
		
		service = ServicesDataAccess.getById(id);
		
		processResponse();
		return service;
	}
}
