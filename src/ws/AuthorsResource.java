package ws;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import dao.ScientistDAO;
import dto.AuthorDTO;

@Path("authors")
public class AuthorsResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllAuthors() {
		ArrayList<AuthorDTO> authorsList = ScientistDAO.getAllAuthors();
		Gson gson = new Gson();
		String result = gson.toJson(authorsList);
		return result;
	}

}
