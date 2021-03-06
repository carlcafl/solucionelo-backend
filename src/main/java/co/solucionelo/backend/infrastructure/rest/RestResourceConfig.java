package co.solucionelo.backend.infrastructure.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api/rest/*")
public class RestResourceConfig extends ResourceConfig {

	public RestResourceConfig()
	{
		packages("co.solucionelo.backend.services,co.solucionelo.backend.services.util");
		register(JacksonFeature.class);
		register(new CORSFilter());
		register(org.glassfish.jersey.server.mvc.jsp.JspMvcFeature.class);
	}
}
