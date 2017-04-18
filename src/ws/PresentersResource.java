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
	public String getScientists() {
		ArrayList<ScientistDTO> presentersList = ScientistDAO.getAllPresenters();
		Gson gson = new Gson();
		String result = gson.toJson(presentersList);
		return result;
	}

	@GET
	@Path("{eid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getScientist(@PathParam("eid") String EID) {
		ScientistDTO scientistDTO = ScientistDAO.getScientist(EID);
		Gson gson = new Gson();
		String result = gson.toJson(scientistDTO);
		return result;
	}

}
