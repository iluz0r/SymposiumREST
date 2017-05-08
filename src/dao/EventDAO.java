package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import com.mysql.jdbc.Connection;

import dto.EventDTO;

public class EventDAO {

	public static ArrayList<EventDTO> getAllEvents() {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ArrayList<EventDTO> eventsList = null;

		try {
			conn = (Connection) ConnectionManager.getConnection();
			pStmt = conn.prepareStatement("SELECT * from event ORDER BY StartTime");
			rs = pStmt.executeQuery();
			eventsList = new ArrayList<EventDTO>();
			SimpleDateFormat sdfDate = new SimpleDateFormat("MMM d, yyyy", Locale.US);
			SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm a");

			while (rs.next()) {
				EventDTO event = new EventDTO();
				event.setID(rs.getString("ID"));
				event.setDate(sdfDate.format(rs.getDate("Date")));
				event.setStartTime(sdfTime.format(rs.getTime("StartTime")));
				event.setEndTime(sdfTime.format(rs.getTime("EndTime")));
				event.setName(rs.getString("Name"));
				event.setDescription(rs.getString("Description"));
				event.setLocationID(rs.getString("LocationID"));
				event.setType(rs.getInt("Type"));
				event.setChairEID(rs.getString("ChairEID"));
				eventsList.add(event);
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
		return eventsList;
	}

}
