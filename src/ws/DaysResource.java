package ws;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import dao.DayDAO;
import dto.DayDTO;

@Path("days")
public class DaysResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllDays() {
		ArrayList<DayDTO> daysList = DayDAO.getAllDays();
		Gson gson = new Gson();
		String result = gson.toJson(daysList);
		return result;
	}

}
