package co.solucionelo.backend.services;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.solucionelo.backend.model.UserInfo;

@Path("/users")
public class RESTUsers extends RESTService {

	@OPTIONS
	@Path("/")
	public Response doOptions() {
		processResponse();
		return Response.ok().build();
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON) 
	public List<UserInfo> listUsers() throws URISyntaxException, SQLException {
		List<UserInfo> list = new ArrayList<UserInfo>();

		//TODO DataAccess
		//list = PlatformsDataAccess.listAll();
		processResponse();
		return list;
	}

}
