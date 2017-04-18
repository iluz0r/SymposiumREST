package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			pStmt = conn.prepareStatement("SELECT * from event");
			rs = pStmt.executeQuery();
			eventsList = new ArrayList<EventDTO>();

			while (rs.next()) {
				EventDTO event = new EventDTO();
				event.setID(rs.getString("ID"));
				event.setDate(rs.getDate("Date"));
				event.setStartTime(rs.getTime("StartTime"));
				event.setEndTime(rs.getTime("EndTime"));
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

	public static EventDTO getEventByID(String ID) {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		EventDTO event = null;

		try {
			conn = (Connection) ConnectionManager.getConnection();
			pStmt = conn.prepareStatement("SELECT * from event WHERE ID = '" + ID + "'");
			rs = pStmt.executeQuery();
			event = new EventDTO();

			if (rs.next()) {
				event.setID(rs.getString("ID"));
				event.setDate(rs.getDate("Date"));
				event.setStartTime(rs.getTime("StartTime"));
				event.setEndTime(rs.getTime("EndTime"));
				event.setName(rs.getString("Name"));
				event.setDescription(rs.getString("Description"));
				event.setLocationID(rs.getString("LocationID"));
				event.setType(rs.getInt("Type"));
				event.setChairEID(rs.getString("ChairEID"));
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
		return event;
	}

}
