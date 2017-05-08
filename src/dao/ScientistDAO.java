package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import dto.ChairDTO;
import dto.AuthorDTO;

public class ScientistDAO {

	public static ArrayList<AuthorDTO> getAllPresenters() {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ArrayList<AuthorDTO> presentersList = null;

		try {
			conn = (Connection) ConnectionManager.getConnection();
			pStmt = conn.prepareStatement(
					"SELECT * FROM (((((scientist INNER JOIN presents ON scientist.EID = presents.AuthorEID) INNER JOIN isaffiliatedwith ON presents.AuthorEID = isaffiliatedwith.ScientistEID)) INNER JOIN hassubjectareas ON presents.AuthorEID = hassubjectareas.ScientistEID)) WHERE EID in (SELECT AuthorEID from presents WHERE PaperID in (SELECT ID from Paper WHERE EventID in (SELECT ID FROM Event WHERE Type != 2)))");
			rs = pStmt.executeQuery();
			presentersList = new ArrayList<AuthorDTO>();

			while (rs.next()) {
				boolean exists = false;
				for (AuthorDTO p : presentersList) {
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
					AuthorDTO presenter = new AuthorDTO();
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

	public static ArrayList<AuthorDTO> getAllInvitedSpeakers() {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ArrayList<AuthorDTO> speakersList = null;

		try {
			conn = (Connection) ConnectionManager.getConnection();
			pStmt = conn.prepareStatement(
					"SELECT * FROM (((((scientist INNER JOIN presents ON scientist.EID = presents.AuthorEID) INNER JOIN isaffiliatedwith ON presents.AuthorEID = isaffiliatedwith.ScientistEID)) INNER JOIN hassubjectareas ON presents.AuthorEID = hassubjectareas.ScientistEID)) WHERE EID in (SELECT AuthorEID from presents WHERE PaperID in (SELECT ID from Paper WHERE EventID in (SELECT ID FROM Event WHERE Type = 1)))");
			rs = pStmt.executeQuery();
			speakersList = new ArrayList<AuthorDTO>();

			while (rs.next()) {
				boolean exists = false;
				for (AuthorDTO s : speakersList) {
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
					AuthorDTO speaker = new AuthorDTO();
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

	public static ArrayList<ChairDTO> getAllChairs() {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ArrayList<ChairDTO> chairsList = null;

		try {
			conn = (Connection) ConnectionManager.getConnection();
			pStmt = conn.prepareStatement(
					"SELECT * FROM ((scientist INNER JOIN isaffiliatedwith ON scientist.EID = isaffiliatedwith.ScientistEID) INNER JOIN hassubjectareas ON scientist.EID = hassubjectareas.ScientistEID) WHERE EID in (SELECT ChairEID from event WHERE Type != 2)");
			rs = pStmt.executeQuery();
			chairsList = new ArrayList<ChairDTO>();

			while (rs.next()) {
				boolean exists = false;
				for (ChairDTO c : chairsList) {
					if (c.getEID().equals(rs.getString("EID"))) {
						String affiliationID = rs.getString("AffiliationID");
						String subjectAreaID = rs.getString("SubjectAreaID");
						if (!c.getAffiliationsID().contains(affiliationID))
							c.getAffiliationsID().add(affiliationID);
						if (!c.getSubjectAreasID().contains(subjectAreaID))
							c.getSubjectAreasID().add(subjectAreaID);
						exists = true;
					}
				}
				if (!exists) {
					ChairDTO chair = new ChairDTO();
					chair.setEID(rs.getString("EID"));
					chair.setFirstName(rs.getString("FirstName"));
					chair.setLastName(rs.getString("LastName"));
					chair.setPictureURL(rs.getString("Picture"));
					chair.setHindex(rs.getInt("Hindex"));
					chair.setDocumentCount(rs.getInt("DocumentCount"));
					chair.setCitedByCount(rs.getInt("CitedByCount"));
					chair.setCitationCount(rs.getInt("CitationCount"));
					chair.setEmail(rs.getString("Email"));
					chair.setPhone(rs.getString("Phone"));
					chair.addAffiliationID(rs.getString("AffiliationID"));
					chair.addSubjectAreaID(rs.getString("SubjectAreaID"));
					chairsList.add(chair);
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
		return chairsList;
	}

	public static ArrayList<AuthorDTO> getAllAuthors() {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ArrayList<AuthorDTO> authorsList = null;

		try {
			conn = (Connection) ConnectionManager.getConnection();
			pStmt = conn.prepareStatement(
					"SELECT * FROM (((((scientist INNER JOIN hasauthor ON scientist.EID = hasauthor.AuthorEID) INNER JOIN isaffiliatedwith ON hasauthor.AuthorEID = isaffiliatedwith.ScientistEID)) INNER JOIN hassubjectareas ON hasauthor.AuthorEID = hassubjectareas.ScientistEID))");
			rs = pStmt.executeQuery();
			authorsList = new ArrayList<AuthorDTO>();

			while (rs.next()) {
				boolean exists = false;
				for (AuthorDTO a : authorsList) {
					if (a.getEID().equals(rs.getString("EID"))) {
						String paperID = rs.getString("PaperID");
						String affiliationID = rs.getString("AffiliationID");
						String subjectAreaID = rs.getString("SubjectAreaID");
						if (!a.getAffiliationsID().contains(affiliationID))
							a.getAffiliationsID().add(affiliationID);
						if (!a.getSubjectAreasID().contains(subjectAreaID))
							a.getSubjectAreasID().add(subjectAreaID);
						if (!a.getPapersID().contains(paperID))
							a.getPapersID().add(paperID);
						exists = true;
					}
				}
				if (!exists) {
					AuthorDTO author = new AuthorDTO();
					author.setEID(rs.getString("EID"));
					author.setFirstName(rs.getString("FirstName"));
					author.setLastName(rs.getString("LastName"));
					author.setPictureURL(rs.getString("Picture"));
					author.setHindex(rs.getInt("Hindex"));
					author.setDocumentCount(rs.getInt("DocumentCount"));
					author.setCitedByCount(rs.getInt("CitedByCount"));
					author.setCitationCount(rs.getInt("CitationCount"));
					author.setEmail(rs.getString("Email"));
					author.setPhone(rs.getString("Phone"));
					author.addPaperID(rs.getString("PaperID"));
					author.addAffiliationID(rs.getString("AffiliationID"));
					author.addSubjectAreaID(rs.getString("SubjectAreaID"));
					authorsList.add(author);
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
		return authorsList;
	}

}
