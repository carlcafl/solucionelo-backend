package co.solucionelo.backend.services;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.solucionelo.backend.dataAccess.UsersDataAccess;
import co.solucionelo.backend.model.UserInfo;

@Path("/users")
public class RESTUsers extends RESTService {

	@OPTIONS
	@Path("/")
	public Response doOptions() {
		//processResponse();
		return Response.ok()
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
				.build();
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON) 
	public List<UserInfo> listUsers() throws URISyntaxException, SQLException {
		List<UserInfo> list = new ArrayList<UserInfo>();
		list = UsersDataAccess.listAll();
		processResponse();
		return list;
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public Response addNew(UserInfo user) throws URISyntaxException, SQLException {	
		processResponse();
		if (user.getIpAddress() == null || "".equals(user.getIpAddress())) {
			user.setIpAddress( request.getRemoteAddr() );
		}
		int id = UsersDataAccess.insertNew(user);
		user.setId(id);
		return Response.status(Response.Status.CREATED)
				.header("Location", "/users/" + id)
				.entity("/users/" + id).build();
	}
}
