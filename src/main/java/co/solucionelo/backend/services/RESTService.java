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
		/*String reqHead = request.getHeader("Access-Control-Request-Headers");		 
        if(null != reqHead && !reqHead.equals(""))
        	response.addHeader("Access-Control-Allow-Headers", reqHead + ", X-Requested-With, Access-Control-Allow-Origin");
        else
        	response.addHeader("Access-Control-Allow-Headers", "Origin, Content-Type, X-Requested-With, Access-Control-Allow-Origin, Access-Control-Allow-Headers, Authorization, X-Auth-Token, Accept, Key");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods",
				"GET, POST, PUT, DELETE, OPTIONS, HEAD");*/		
	}
}
