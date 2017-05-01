package ws;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.EventDAO;
import dto.EventDTO;

@Path("events")
public class EventsResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllEvents() {
		ArrayList<EventDTO> eventsList = EventDAO.getAllEvents();
		Gson gson = new GsonBuilder().setDateFormat("EEE d").create();
		String result = gson.toJson(eventsList);
		return result;
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getEventByID(@PathParam("id") String ID) {
		EventDTO event = EventDAO.getEventByID(ID);
		Gson gson = new Gson();
		String result = gson.toJson(event);
		return result;
	}

	/* DA METTERE NELLA DaysResource sotto /days/{date}/events */
	@GET
	@Path("date/{date}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getEventByDate(@PathParam("date") String date) {
		ArrayList<EventDTO> eventsList = EventDAO.getAllEventsByDate(date);
		Gson gson = new Gson();
		String result = gson.toJson(eventsList);
		return result;
	}

}
