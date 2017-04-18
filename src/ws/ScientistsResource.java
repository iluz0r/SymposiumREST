package ws;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import dao.ScientistDAO;
import dto.ScientistDTO;

@Path("scientists")
public class ScientistsResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllScientists() {
		ArrayList<ScientistDTO> scientistsList = ScientistDAO.getAllScientists();
		Gson gson = new Gson();
		String result = gson.toJson(scientistsList);
		return result;
	}

	@GET
	@Path("{eid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getScientistByEID(@PathParam("eid") String EID) {
		ScientistDTO scientist = ScientistDAO.getScientistByEID(EID);
		Gson gson = new Gson();
		String result = gson.toJson(scientist);
		return result;
	}

}
