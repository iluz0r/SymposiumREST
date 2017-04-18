package ws;

import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import dao.ScientistsDAO;
import dto.ScientistDTO;

@Path("scientists")
public class ScientistsResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getScientists() {
		ScientistsDAO scientistDAO = new ScientistsDAO();
		ArrayList<ScientistDTO> scientistsList = scientistDAO.getAllScientists();
		Gson gson = new Gson();
		String result = gson.toJson(scientistsList);
		return result;
	}
	
	@GET
	@Path("{eid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getScientist(@PathParam("eid") String EID) {
		ScientistsDAO scientistDAO = new ScientistsDAO();
		ScientistDTO scientistDTO = scientistDAO.getScientist(EID);
		Gson gson = new Gson();
		String result = gson.toJson(scientistDTO);
		return result;
	}
	
}
