package ing.cursus.fietsenzaak.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ing.cursus.fietsenzaak.core.Fiets;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.annotation.Timed;
import com.google.gson.Gson;


@Path("/fietsen")
public class FietsResource {

	private List<Fiets> fietsen = new ArrayList<Fiets>();
	private int fietsID = 1;
    

	
	@POST
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Timed
	public Fiets maakFiets(@QueryParam("name") String fietsnaam, @QueryParam("bedrag") double bedrag ) throws IOException{
		
		Fiets fiets = new Fiets(fietsID++, fietsnaam,bedrag);
		fietsen.add(fiets);
		return fiets;
		
	}
	
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Timed
	public String showFietsen(){
		
		String json = new Gson().toJson(fietsen);
		return json;
	}
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Timed
	@Path("/{id}")
	public String showEenFiets(@PathParam("id") int fietsId){

		Fiets fiets = null;
		
		for (Fiets collect: fietsen){
			if(collect.getId() == fietsId){
				fiets = collect;
				break;
			}
		}

		
		if(fiets != null){
			String json = new Gson().toJson(fiets);
			return json;
		}
		else{
			String error = "Fietsnummer bestaat niet";
			return error;
		}
		

		
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Timed
	@Path("delete/{id}")
	public Response deleteFiets(@PathParam("id") int fietsId) {
		
		int count = 0;
		
		for (Fiets collect: fietsen){
			
			if(collect.getId() == fietsId){
				
				fietsen.remove(count);
				
				break;
			}
			count++;
		}
		return Response.status(200).entity("Fiets met "+ fietsId+ " is gewist").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Timed
	@Path("update/{id}")
	public String updateNaam(@PathParam("id") int fietsId, @QueryParam("naam") String naam) {
		
		int count = 0;
		for (Fiets collect: fietsen){
			if(collect.getId() == fietsId){
			    fietsen.get(count).setNaam(naam);	
				break;	
				}	
			count++;
		
	}
		return showEenFiets(fietsId);
		
}
	
	
}
