package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import dto.PresenterDTO;
import dto.SpeakerDTO;

public class ScientistDAO {

	public static ArrayList<PresenterDTO> getAllPresenters() {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ArrayList<PresenterDTO> presentersList = null;

		try {
			conn = (Connection) ConnectionManager.getConnection();
			pStmt = conn.prepareStatement(
					"SELECT * FROM (((((scientist INNER JOIN presents ON scientist.EID = presents.AuthorEID) INNER JOIN isaffiliatedwith ON presents.AuthorEID = isaffiliatedwith.ScientistEID)) INNER JOIN hassubjectareas ON presents.AuthorEID = hassubjectareas.ScientistEID)) WHERE EID in (SELECT AuthorEID from presents WHERE PaperID in (SELECT ID from Paper WHERE EventID in (SELECT ID FROM Event WHERE Type = 0)))");
			rs = pStmt.executeQuery();
			presentersList = new ArrayList<PresenterDTO>();

			while (rs.next()) {
				boolean exists = false;
				for (PresenterDTO p : presentersList) {
					if (p.getEID().equals(rs.getString("EID"))) {
						String paperID = rs.getString("PaperID");
						String affiliationID = rs.getString("AffiliationID");
						String subjectAreaID = rs.getString("SubjectAreaID");
						if (!p.getPapersID().contains(paperID))
							p.getPapersID().add(paperID);
						if (!p.getAffiliationsID().contains(affiliationID))
							p.getAffiliationsID().add(affiliationID);
						if (!p.getSubjectAreasID().contains(subjectAreaID))
							p.getSubjectAreasID().add(subjectAreaID);
						exists = true;
					}
				}
				if (!exists) {
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
					presenter.addAffiliationID(rs.getString("AffiliationID"));
					presenter.addSubjectAreaID(rs.getString("SubjectAreaID"));
					presentersList.add(presenter);
				}
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

	public static ArrayList<SpeakerDTO> getAllInvitedSpeakers() {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ArrayList<SpeakerDTO> speakersList = null;

		try {
			conn = (Connection) ConnectionManager.getConnection();
			pStmt = conn.prepareStatement(
					"SELECT * FROM (((((scientist INNER JOIN presents ON scientist.EID = presents.AuthorEID) INNER JOIN isaffiliatedwith ON presents.AuthorEID = isaffiliatedwith.ScientistEID)) INNER JOIN hassubjectareas ON presents.AuthorEID = hassubjectareas.ScientistEID)) WHERE EID in (SELECT AuthorEID from presents WHERE PaperID in (SELECT ID from Paper WHERE EventID in (SELECT ID FROM Event WHERE Type = 1)))");
			rs = pStmt.executeQuery();
			speakersList = new ArrayList<SpeakerDTO>();

			while (rs.next()) {
				boolean exists = false;
				for (SpeakerDTO s : speakersList) {
					if (s.getEID().equals(rs.getString("EID"))) {
						String paperID = rs.getString("PaperID");
						String affiliationID = rs.getString("AffiliationID");
						String subjectAreaID = rs.getString("SubjectAreaID");
						if (!s.getPapersID().contains(paperID))
							s.getPapersID().add(paperID);
						if (!s.getAffiliationsID().contains(affiliationID))
							s.getAffiliationsID().add(affiliationID);
						if (!s.getSubjectAreasID().contains(subjectAreaID))
							s.getSubjectAreasID().add(subjectAreaID);
						exists = true;
					}
				}
				if (!exists) {
					SpeakerDTO speaker = new SpeakerDTO();
					speaker.setEID(rs.getString("EID"));
					speaker.setFirstName(rs.getString("FirstName"));
					speaker.setLastName(rs.getString("LastName"));
					speaker.setPictureURL(rs.getString("Picture"));
					speaker.setHindex(rs.getInt("Hindex"));
					speaker.setDocumentCount(rs.getInt("DocumentCount"));
					speaker.setCitedByCount(rs.getInt("CitedByCount"));
					speaker.setCitationCount(rs.getInt("CitationCount"));
					speaker.setEmail(rs.getString("Email"));
					speaker.setPhone(rs.getString("Phone"));
					speaker.addPaperID(rs.getString("PaperID"));
					speaker.addAffiliationID(rs.getString("AffiliationID"));
					speaker.addSubjectAreaID(rs.getString("SubjectAreaID"));
					speakersList.add(speaker);
				}
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
