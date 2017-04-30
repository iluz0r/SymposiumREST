package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

public class DateDAO {

	public static ArrayList<Date> getAllDates() {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ArrayList<Date> daysList = null;

		try {
			conn = (Connection) ConnectionManager.getConnection();
			pStmt = conn.prepareStatement("SELECT DISTINCT Date from event");
			rs = pStmt.executeQuery();
			daysList = new ArrayList<Date>();

			while (rs.next()) {
				Date date = rs.getDate("Date");
				daysList.add(date);
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
