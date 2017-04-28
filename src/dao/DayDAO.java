package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import dto.DayDTO;

public class DayDAO {

	public static ArrayList<DayDTO> getAllDays() {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ArrayList<DayDTO> daysList = null;

		try {
			conn = (Connection) ConnectionManager.getConnection();
			pStmt = conn.prepareStatement("SELECT * from day");
			rs = pStmt.executeQuery();
			daysList = new ArrayList<DayDTO>();

			while (rs.next()) {
				DayDTO day = new DayDTO();
				day.setDate(rs.getDate("Date"));
				day.setOverview(rs.getString("Overview"));
				daysList.add(day);
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
		return daysList;
	}

}
