package dto;

import java.util.ArrayList;

public class PresenterDTO extends ScientistDTO {

	private ArrayList<String> papersID;

	public PresenterDTO() {
		papersID = new ArrayList<String>();
	}

	public void addPaperID(String paperID) {
		papersID.add(paperID);
	}

}
