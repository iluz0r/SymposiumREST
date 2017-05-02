package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import dto.PresenterDTO;
import dto.ScientistDTO;

public class ScientistDAO {

	public static ArrayList<PresenterDTO> getAllPresenters() {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ArrayList<PresenterDTO> presentersList = null;

		try {
			conn = (Connection) ConnectionManager.getConnection();
			pStmt = conn.prepareStatement("SELECT * FROM presents, scientist WHERE AuthorEID = EID");
			rs = pStmt.executeQuery();
			presentersList = new ArrayList<PresenterDTO>();

			while (rs.next()) {
				PresenterDTO presenter = new PresenterDTO();
				presenter.setEID(rs.getString("EID"));
				presenter.setFirstName(rs.getString("FirstName"));
				presenter.setLastName(rs.getString("LastName"));
				presenter.setPictureURL(rs.getString("Picture"));
				presenter.setHindex(rs.getInt("Hindex"));
				presenter.setDocumentCount(rs.getInt("DocumentCount"));
				presenter.setCitedByCount(rs.getInt("CitedByCount"));
				presenter.setCitationCount(rs.getInt("CitationCount"));
				presenter.setEmail(rs.getString("Email"));
				presenter.setPhone(rs.getString("Phone"));
				presenter.addPaperID(rs.getString("PaperID"));
				presentersList.add(presenter);
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

	public static ArrayList<ScientistDTO> getAllInvitedSpeakers() {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ArrayList<ScientistDTO> speakersList = null;

		try {
			conn = (Connection) ConnectionManager.getConnection();
			pStmt = conn.prepareStatement(
					"SELECT * FROM scientist WHERE EID in (SELECT AuthorEID from presents WHERE PaperID in (SELECT ID from Paper WHERE EventID in (SELECT ID FROM Event WHERE Type = 1)))");
			rs = pStmt.executeQuery();
			speakersList = new ArrayList<ScientistDTO>();

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
				speakersList.add(scientist);
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
		return speakersList;
	}

}
