package dto;

import java.sql.Date;
import java.sql.Time;

public class EventDTO {

	private String ID;
	private Date date;
	private Time startTime;
	private Time endTime;
	private String name;
	private String description;
	private String locationID;
	private int type;
	private String chairEID;

	public EventDTO() {
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocationID() {
		return locationID;
	}

	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getChairEID() {
		return chairEID;
	}

	public void setChairEID(String chairEID) {
		this.chairEID = chairEID;
	}

}
