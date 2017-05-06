package ws;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import dao.ScientistDAO;
import dto.ChairDTO;

@Path("chairs")
public class ChairsResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllChairs() {
		ArrayList<ChairDTO> chairsList = ScientistDAO.getAllChairs();
		Gson gson = new Gson();
		String result = gson.toJson(chairsList);
		return result;
	}

}
