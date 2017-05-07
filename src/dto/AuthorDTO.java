package dto;

import java.util.ArrayList;

public class AuthorDTO extends ScientistDTO {

	private ArrayList<String> papersID;
	private ArrayList<String> affiliationsID;
	private ArrayList<String> subjectAreasID;

	public AuthorDTO() {
		papersID = new ArrayList<String>();
		affiliationsID = new ArrayList<String>();
		subjectAreasID = new ArrayList<String>();
	}

	public void addPaperID(String paperID) {
		papersID.add(paperID);
	}

	public void addSubjectAreaID(String areaID) {
		subjectAreasID.add(areaID);
	}

	public void addAffiliationID(String affiliationID) {
		affiliationsID.add(affiliationID);
	}

	public ArrayList<String> getPapersID() {
		return papersID;
	}

	public ArrayList<String> getAffiliationsID() {
		return affiliationsID;
	}

	public ArrayList<String> getSubjectAreasID() {
		return subjectAreasID;
	}

}
