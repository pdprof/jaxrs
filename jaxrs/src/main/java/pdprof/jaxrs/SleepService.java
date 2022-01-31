package pdprof.jaxrs;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("sleep")
public class SleepService {
    
	@GET
    public String hello() {
        return "Hello World!!";
    }
	
	@POST
    @Produces(MediaType.TEXT_PLAIN)
	public String sleep(@FormParam("time") String t) {
		int i = 10000;
		try { i = Integer.parseInt(t); } catch (Exception e) {}
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Sleep " + t + " milliseconds";
	}
	
}
