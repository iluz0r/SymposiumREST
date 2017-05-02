package ws;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import dao.PaperDAO;
import dao.ScientistDAO;
import dto.PaperDTO;
import dto.ScientistDTO;

@Path("papers")
public class PapersResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllPapers() {
		ArrayList<PaperDTO> papersList = PaperDAO.getAllPapers();
		Gson gson = new Gson();
		String result = gson.toJson(papersList);
		return result;
	}

	@GET
	@Path("{id}/presenters")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllPresentersByPaperID(@PathParam("id") String paperID) {
		ArrayList<ScientistDTO> presentersList = ScientistDAO.getAllPresentersByPaperID(paperID);
		Gson gson = new Gson();
		String result = gson.toJson(presentersList);
		return result;
	}

}
