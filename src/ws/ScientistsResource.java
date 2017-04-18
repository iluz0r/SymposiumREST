package ws;

import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import dao.ScientistDAO;
import dto.ScientistDTO;

@Path("scientists")
public class ScientistsResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getScientists() {
		ScientistDAO scientistDAO = new ScientistDAO();
		ArrayList<ScientistDTO> scientistsList = scientistDAO.getAllScientists();
		Gson gson = new Gson();
		String result = gson.toJson(scientistsList);
		return result;
	}
	
}
