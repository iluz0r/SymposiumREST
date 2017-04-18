package ws;

import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import dao.ScientistDAO;
import dto.ScientistDTO;

@Path("presenters")
public class PresentersResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllPresenters() {
		ArrayList<ScientistDTO> presentersList = ScientistDAO.getAllPresenters();
		Gson gson = new Gson();
		String result = gson.toJson(presentersList);
		return result;
	}

}
