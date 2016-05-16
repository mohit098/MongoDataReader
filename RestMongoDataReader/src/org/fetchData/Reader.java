package org.fetchData;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/webService")
public class Reader {

	@SuppressWarnings("static-access")
	@Path("{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})	
	public Response userInput(@PathParam("id") int id)
	{
		PersonDAOImpl personDAO = new PersonDAOImpl();
		List<Person> person = new ArrayList<Person>();
		Response res = null;

		try {
			switch(id)
			{
			case 701:

					person = personDAO.readById("Mohit");
					res = Response.ok().entity(new GenericEntity<List<Person>>(person){}).build();
					return res;

			case 702:
				person = personDAO.getAll();
				res = Response.ok().entity(new GenericEntity<List<Person>>(person){}).build();
				return res;
				
				default:
					String invalidRequest = "InvalidRequest";
					return res.status(520).entity(invalidRequest).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
		
	}
	
}
