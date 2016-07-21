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
	private static final String INSERT_USER_SQL = "INSERT INTO tblUsers (registeredDate, ipAddress, idType, idNumber, firstName, lastName, phone, mobile, email, referrer, otherServices) VALUES ({{values}}) RETURNING id";
	private static final String INSERT_SERVICES_BY_USER_SQL = "INSERT INTO tblServicesByUser (userId, serviceId) VALUES ({{values}}) RETURNING id";
	
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
				user.setReferrer(rs.getString("referrer"));
				user.setIpAddress(rs.getString("ipAddress"));
				user.setRegisteredDate(rs.getDate("registeredDate"));
				user.setOtherServices(rs.getString("otherServices"));
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
				service = ServicesDataAccess.getById(rs.getInt("serviceId"), connection);
				list.add(service);
			}
		return list;
	}
	
	public static int insertNew(UserInfo user) throws URISyntaxException, SQLException {
		int id = 0;

		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			Statement stmt = connection.createStatement();
			String sql = INSERT_USER_SQL.replace("{{values}}", "now(), " + "'" + (user.getIpAddress()==null?"":user.getIpAddress()) + "','" + (user.getIdType()==null?"":user.getIdType()) + "','" + (user.getIdNumber()==null?"":user.getIdNumber()) + "','" + (user.getFirstName()==null?"":user.getFirstName()) + "','" + (user.getLastName()==null?"":user.getLastName()) + "','" + (user.getPhoneNumber()==null?"":user.getPhoneNumber()) + "','" + (user.getMobileNumber()==null?"":user.getMobileNumber()) + "','" + (user.getEmail()==null?"":user.getEmail()) + "','" + (user.getReferrer()==null?"":user.getReferrer()) +  "','" + (user.getOtherServices()==null?"":user.getOtherServices()) + "'" );
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				id = rs.getInt("id");
				user.setId(id);
			}
			
			insertServices(user, connection);
			
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
		return id;
	}	

	private static void insertServices(UserInfo user, Connection connection) throws URISyntaxException, SQLException {

		int id = 0;
		Statement stmt = connection.createStatement();
		for (Service service : user.getOfferedServices()) {
			String sql = INSERT_SERVICES_BY_USER_SQL.replace("{{values}}", "'" + user.getId() + "','" + service.getId() + "'" );
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				id = rs.getInt("id");
			}
		}
	}	
}
