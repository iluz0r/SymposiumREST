package ws;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import dao.ScientistDAO;
import dto.PresenterDTO;

@Path("presenters")
public class PresentersResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllPresenters() {
		ArrayList<PresenterDTO> presentersList = ScientistDAO.getAllPresenters();
		Gson gson = new Gson();
		String result = gson.toJson(presentersList);
		return result;
	}

}
