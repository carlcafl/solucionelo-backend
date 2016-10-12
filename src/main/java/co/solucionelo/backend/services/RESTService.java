package co.solucionelo.backend.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

public abstract class RESTService {

	@Context
	protected HttpServletResponse response;
	@Context
	protected HttpServletRequest  request;

	protected void processResponse() {
		//Procesar? Ya lo hace el filtro
	}
}
