package ws;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import dao.LocationDAO;
import dto.LocationDTO;

@Path("locations")
public class LocationsResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllLocations() {
		ArrayList<LocationDTO> locationsList = LocationDAO.getAllLocations();
		Gson gson = new Gson();
		String result = gson.toJson(locationsList);
		return result;
	}

}
