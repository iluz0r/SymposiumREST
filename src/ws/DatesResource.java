package ws;

import java.sql.Date;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.DateDAO;

@Path("dates")
public class DatesResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllDates() {
		ArrayList<Date> datesList = DateDAO.getAllDates();
		Gson gson = new GsonBuilder().setDateFormat("EEE d").create();
		String result = gson.toJson(datesList);
		return result;
	}

}
