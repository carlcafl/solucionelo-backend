package co.solucionelo.backend.dataAccess;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.solucionelo.backend.model.Service;
import co.solucionelo.backend.model.UserInfo;

public class UsersDataAccess {
	private static final String LIST_USERS_SQL = "SELECT * FROM tblUsers";
	private static final String LIST_SERVICES_BY_USER_ID_SQL = "SELECT * FROM tblServicesByUser WHERE userId = ";
	
	public static List<UserInfo> listAll() throws URISyntaxException, SQLException {
		List<UserInfo> list = new ArrayList<UserInfo>();

		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(LIST_USERS_SQL);
			while (rs.next()) {
				UserInfo user = new UserInfo();
				user.setId(rs.getInt("id"));
				user.setIdType(rs.getString("idType"));
				user.setIdNumber(rs.getString("idNumber"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmail(rs.getString("email"));
				user.setPhoneNumber(rs.getString("phone"));
				user.setMobileNumber(rs.getString("mobile"));
				user.setCity(rs.getString("city"));
				user.setOfferedServices(getByUserId(rs.getInt("id"), connection));
				
				list.add(user);
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

	protected static List<Service> getByUserId(int id) throws URISyntaxException, SQLException {
		List<Service> list = null;

		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			list = getByUserId(id, connection);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
		return list;
	}
	
	protected static List<Service> getByUserId(int id, Connection connection) throws URISyntaxException, SQLException {
		Service service = null;
		List<Service> list = new ArrayList<Service>();

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(LIST_SERVICES_BY_USER_ID_SQL + Integer.toString(id));
			while (rs.next()) {
				service = ServicesDataAccess.getById(rs.getInt("id"), connection);
				list.add(service);
			}
		return list;
	}

}
