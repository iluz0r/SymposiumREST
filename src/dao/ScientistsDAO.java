package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import dto.ScientistDTO;

public class ScientistsDAO {

	public ScientistsDAO() {
		
	}
	
	public ArrayList<ScientistDTO> getAllScientists() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("");
		dataSource.setServerName("localhost");
		dataSource.setPort(3306);
		dataSource.setDatabaseName("conferenceproj");

		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ArrayList<ScientistDTO> scientistsList = null;

		try {
			conn = (Connection) dataSource.getConnection();
			pStmt = conn.prepareStatement("SELECT * from scientist");
			rs = pStmt.executeQuery();
			scientistsList = new ArrayList<ScientistDTO>();
			
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
				scientistsList.add(scientist);
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
		
		return scientistsList;
	}
	
	public ScientistDTO getScientist(String EID) {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("");
		dataSource.setServerName("localhost");
		dataSource.setPort(3306);
		dataSource.setDatabaseName("conferenceproj");

		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ScientistDTO scientist = null;
		
		try {
			conn = (Connection) dataSource.getConnection();
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
