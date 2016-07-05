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
		UserInfo user = new UserInfo();
		user.setFirstName("Camilo");
		user.setLastName("Aristizabal");
		user.setIdNumber("123456789");
		user.setIdType("CC");
		user.setEmail("cariztizabalz@sura.com.co");
		user.setMobileNumber("3001234567");
		user.setPhoneNumber("1234567");
		list.add(user);
		UserInfo user2 = new UserInfo();
		user2.setFirstName("Carlos");
		user2.setLastName("Carmona");
		user2.setIdNumber("71383304");
		user2.setIdType("CC");
		user2.setEmail("cacarmona@sura.com.co");
		user2.setMobileNumber("3006168980");
		user2.setPhoneNumber("2703374");
		list.add(user2);
		
		//list = PlatformsDataAccess.listAll();
		processResponse();
		return list;
	}

}
