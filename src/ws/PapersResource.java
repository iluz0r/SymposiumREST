package ws;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import dao.PaperDAO;
import dto.PaperDTO;

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

}
