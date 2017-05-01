package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import dto.LocationDTO;

public class LocationDAO {

	public static ArrayList<LocationDTO> getAllLocations() {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ArrayList<LocationDTO> locationsList = null;

		try {
			conn = (Connection) ConnectionManager.getConnection();
			pStmt = conn.prepareStatement("SELECT DISTINCT Date from event ORDER BY Date");
			rs = pStmt.executeQuery();
			locationsList = new ArrayList<LocationDTO>();

			while (rs.next()) {
				LocationDTO location = new LocationDTO();
				location.setID(rs.getString("ID"));
				location.setName(rs.getString("Name"));
				location.setAddress(rs.getString("Address"));
				location.setCity(rs.getString("City"));
				location.setCountry(rs.getString("Country"));
				locationsList.add(location);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return locationsList;
	}

}
