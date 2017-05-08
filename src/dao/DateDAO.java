package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import com.mysql.jdbc.Connection;

public class DateDAO {

	public static ArrayList<String> getAllDates() {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ArrayList<String> daysList = null;

		try {
			conn = (Connection) ConnectionManager.getConnection();
			pStmt = conn.prepareStatement("SELECT DISTINCT Date from event ORDER BY Date");
			rs = pStmt.executeQuery();
			daysList = new ArrayList<String>();
			SimpleDateFormat sdfDate = new SimpleDateFormat("MMM d, yyyy", Locale.US);
			
			while (rs.next()) {
				String date = sdfDate.format(rs.getDate("Date"));
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
