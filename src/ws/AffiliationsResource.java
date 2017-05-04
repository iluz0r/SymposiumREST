package ws;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import dao.AffiliationDAO;
import dto.AffiliationDTO;

@Path("affiliations")
public class AffiliationsResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllAffiliations() {
		ArrayList<AffiliationDTO> affiliationsList = AffiliationDAO.getAllAffiliations();
		Gson gson = new Gson();
		String result = gson.toJson(affiliationsList);
		return result;
	}

}
