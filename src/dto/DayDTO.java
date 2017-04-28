package dto;

import java.sql.Date;

public class DayDTO {

	private Date date;
	private String overview;

	public DayDTO() {
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

}
