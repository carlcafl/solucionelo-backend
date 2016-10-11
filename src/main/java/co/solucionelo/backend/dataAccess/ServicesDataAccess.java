package co.solucionelo.backend.dataAccess;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.solucionelo.backend.model.Service;

public class ServicesDataAccess {

	private static final String LIST_SERVICES_SQL = "SELECT * FROM tblServices ORDER BY name";
	private static final String GET_SERVICE_BY_ID_SQL = "SELECT * FROM tblServices WHERE id = ";
	
	public static List<Service> listAll() throws URISyntaxException, SQLException {
		List<Service> list = new ArrayList<Service>();

		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(LIST_SERVICES_SQL);
			while (rs.next()) {
				Service service = new Service();
				service.setId(rs.getInt("id") );
				service.setName(rs.getString("name") );
				
				list.add(service);
			}
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
		return list;
	}

	public static Service getById(int id) throws URISyntaxException, SQLException {
		Service project = null;

		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			project = getById(id, connection);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
		return project;
	}
	
	protected static Service getById(int id, Connection connection) throws URISyntaxException, SQLException {
		Service service = null;

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(GET_SERVICE_BY_ID_SQL + Integer.toString(id));
			while (rs.next()) {
				service = new Service();
				service.setId(rs.getInt("id") );
				service.setName(rs.getString("name"));
				break;
			}
		return service;
	}
}
