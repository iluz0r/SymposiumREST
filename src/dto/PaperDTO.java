package dto;

public class PaperDTO {

	private String ID;
	private String title;
	private String papAbstract;
	private String eventID;

	public PaperDTO() {

	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPapAbstract() {
		return papAbstract;
	}

	public void setPapAbstract(String papAbstract) {
		this.papAbstract = papAbstract;
	}

	public String getEventID() {
		return eventID;
	}

	public void setEventID(String eventID) {
		this.eventID = eventID;
	}

}
