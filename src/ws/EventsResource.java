package ws;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import dao.EventDAO;
import dto.EventDTO;

@Path("events")
public class EventsResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllEvents() {
		ArrayList<EventDTO> eventsList = EventDAO.getAllEvents();
		Gson gson = new Gson();
		String result = gson.toJson(eventsList);
		return result;
	}

}
