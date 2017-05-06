package dto;

import java.util.ArrayList;

public class ChairDTO extends ScientistDTO {
	private ArrayList<String> affiliationsID;
	private ArrayList<String> subjectAreasID;

	public ChairDTO() {
		affiliationsID = new ArrayList<String>();
		subjectAreasID = new ArrayList<String>();
	}

	public void addSubjectAreaID(String areaID) {
		subjectAreasID.add(areaID);
	}

	public void addAffiliationID(String affiliationID) {
		affiliationsID.add(affiliationID);
	}

	public ArrayList<String> getAffiliationsID() {
		return affiliationsID;
	}

	public ArrayList<String> getSubjectAreasID() {
		return subjectAreasID;
	}

}
