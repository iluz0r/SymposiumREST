package ws;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import dao.SubjectAreaDAO;
import dto.SubjectAreaDTO;

@Path("subjectareas")
public class SubjectAreasResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllSubjectAreas() {
		ArrayList<SubjectAreaDTO> areasList = SubjectAreaDAO.getAllSubjectAreas();
		Gson gson = new Gson();
		String result = gson.toJson(areasList);
		return result;
	}

}
