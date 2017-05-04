package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import dto.SubjectAreaDTO;

public class SubjectAreaDAO {

	public static ArrayList<SubjectAreaDTO> getAllSubjectAreas() {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ArrayList<SubjectAreaDTO> subjectAreasList = null;

		try {
			conn = (Connection) ConnectionManager.getConnection();
			pStmt = conn.prepareStatement("SELECT * from subjectarea");
			rs = pStmt.executeQuery();
			subjectAreasList = new ArrayList<SubjectAreaDTO>();

			while (rs.next()) {
				SubjectAreaDTO subjectArea = new SubjectAreaDTO();
				subjectArea.setID(rs.getString("ID"));
				subjectArea.setName(rs.getString("Name"));
				subjectAreasList.add(subjectArea);
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
		return subjectAreasList;
	}

}
