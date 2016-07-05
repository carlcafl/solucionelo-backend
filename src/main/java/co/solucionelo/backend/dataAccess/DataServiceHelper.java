package co.solucionelo.backend.dataAccess;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataServiceHelper {

	private static DataServiceHelper instance = null;

	private DataServiceHelper() {
	}

	public static DataServiceHelper getInstance() {
		if (instance == null)
			instance = new DataServiceHelper();
		return instance;
	}

	public Connection getConnection() throws URISyntaxException, SQLException {
		//TODO: Eliminar. Buscar opci�n para pruebas
		String dbURL = System.getenv("DATABASE_URL");
		if (dbURL==null) {
			dbURL = "postgres://jwyysgwzmdoqmw:gXzRGjpcIQ2JCqQPnEiH26E_Rc@ec2-50-17-253-74.compute-1.amazonaws.com:5432/d3pe5j1q6nik02";
		}		
		URI dbUri = new URI(dbURL);

		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		int port = dbUri.getPort();

		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ":" + port
				+ dbUri.getPath();
		
		Properties props = new Properties();
		props.put("user", username);
		props.put("password", password);
		props.put("sslmode","require");
		return DriverManager.getConnection(dbUrl, props);
	}

}
