package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import dto.AffiliationDTO;

public class AffiliationDAO {

	public static ArrayList<AffiliationDTO> getAllAffiliations() {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ArrayList<AffiliationDTO> affiliationsList = null;

		try {
			conn = (Connection) ConnectionManager.getConnection();
			pStmt = conn.prepareStatement("SELECT * from affiliation");
			rs = pStmt.executeQuery();
			affiliationsList = new ArrayList<AffiliationDTO>();

			while (rs.next()) {
				AffiliationDTO affiliation = new AffiliationDTO();
				affiliation.setID(rs.getString("ID"));
				affiliation.setName(rs.getString("Name"));
				affiliation.setAddress(rs.getString("Address"));
				affiliation.setCity(rs.getString("City"));
				affiliation.setCountry(rs.getString("Country"));
				affiliationsList.add(affiliation);
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
		return affiliationsList;
	}
	
}
