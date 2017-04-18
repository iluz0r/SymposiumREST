package dto;

public class ScientistDTO {

	private String EID;
	private String firstName;
	private String lastName;
	private String pictureURL;
	private int hindex;
	private int documentCount;
	private int citedByCount;
	private int citationCount;
	private String email;
	private String phone;

	public ScientistDTO() {
	}

	public String getEID() {
		return EID;
	}

	public void setEID(String eID) {
		EID = eID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPictureURL() {
		return pictureURL;
	}

	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}

	public int getHindex() {
		return hindex;
	}

	public void setHindex(int hindex) {
		this.hindex = hindex;
	}

	public int getDocumentCount() {
		return documentCount;
	}

	public void setDocumentCount(int documentCount) {
		this.documentCount = documentCount;
	}

	public int getCitedByCount() {
		return citedByCount;
	}

	public void setCitedByCount(int citedByCount) {
		this.citedByCount = citedByCount;
	}

	public int getCitationCount() {
		return citationCount;
	}

	public void setCitationCount(int citationCount) {
		this.citationCount = citationCount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
