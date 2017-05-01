package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import dto.PaperDTO;

public class PaperDAO {

	public static ArrayList<PaperDTO> getAllPapers() {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ArrayList<PaperDTO> papersList = null;

		try {
			conn = (Connection) ConnectionManager.getConnection();
			pStmt = conn.prepareStatement("SELECT * from paper");
			rs = pStmt.executeQuery();
			papersList = new ArrayList<PaperDTO>();

			while (rs.next()) {
				PaperDTO paper = new PaperDTO();
				paper.setID(rs.getString("ID"));
				paper.setTitle(rs.getString("Title"));
				paper.setPapAbstract(rs.getString("Abstract"));
				paper.setEventID(rs.getString("EventID"));
				papersList.add(paper);
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
		return papersList;
	}

}
