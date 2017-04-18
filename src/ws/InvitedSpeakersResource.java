package ws;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import dao.ScientistDAO;
import dto.ScientistDTO;

@Path("invitedspeakers")
public class InvitedSpeakersResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllInvitedSpeakers() {
		ArrayList<ScientistDTO> speakersList = ScientistDAO.getAllInvitedSpeakers();
		Gson gson = new Gson();
		String result = gson.toJson(speakersList);
		return result;
	}
	
}