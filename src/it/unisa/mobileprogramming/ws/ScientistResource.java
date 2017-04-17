package it.unisa.mobileprogramming.ws;

import javax.ws.rs.*;

@Path("scientist")
public class ScientistResource {

	private static String string = "Hello World!";
	
	@GET
	@Produces("text/plain")
	public String getString() {
		synchronized (ScientistResource.class) {
			return string;
		}
	}
	
}
