package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import dto.ScientistDTO;

public class ScientistDAO {

	public static ArrayList<ScientistDTO> getAllPresenters() {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ArrayList<ScientistDTO> presentersList = null;

		try {
			conn = (Connection) ConnectionManager.getConnection();
			pStmt = conn.prepareStatement("SELECT * from scientist WHERE EID in (SELECT AuthorEID FROM presents)");
			rs = pStmt.executeQuery();
			presentersList = new ArrayList<ScientistDTO>();

			while (rs.next()) {
				ScientistDTO scientist = new ScientistDTO();
				scientist.setEID(rs.getString("EID"));
				scientist.setFirstName(rs.getString("FirstName"));
				scientist.setLastName(rs.getString("LastName"));
				scientist.setPictureURL(rs.getString("Picture"));
				scientist.setHindex(rs.getInt("Hindex"));
				scientist.setDocumentCount(rs.getInt("DocumentCount"));
				scientist.setCitedByCount(rs.getInt("CitedByCount"));
				scientist.setCitationCount(rs.getInt("CitationCount"));
				scientist.setEmail(rs.getString("Email"));
				scientist.setPhone(rs.getString("Phone"));
				presentersList.add(scientist);
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
		return presentersList;
	}

	public static ScientistDTO getScientist(String EID) {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ScientistDTO scientist = null;

		try {
			conn = (Connection) ConnectionManager.getConnection();
			pStmt = conn.prepareStatement("SELECT * from scientist WHERE EID = '" + EID + "'");
			rs = pStmt.executeQuery();
			scientist = new ScientistDTO();

			while (rs.next()) {
				scientist.setEID(rs.getString("EID"));
				scientist.setFirstName(rs.getString("FirstName"));
				scientist.setLastName(rs.getString("LastName"));
				scientist.setPictureURL(rs.getString("Picture"));
				scientist.setHindex(rs.getInt("Hindex"));
				scientist.setDocumentCount(rs.getInt("DocumentCount"));
				scientist.setCitedByCount(rs.getInt("CitedByCount"));
				scientist.setCitationCount(rs.getInt("CitationCount"));
				scientist.setEmail(rs.getString("Email"));
				scientist.setPhone(rs.getString("Phone"));
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
		return scientist;
	}

}