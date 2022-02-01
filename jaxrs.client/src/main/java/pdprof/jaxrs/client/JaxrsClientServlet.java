package pdprof.jaxrs.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

/**
 * Servlet implementation class JaxrsClientServlet
 */
@WebServlet("/get")
public class JaxrsClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JaxrsClientServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("*** JaxrsClientServlet START ***");
		ClientBuilder cb = ClientBuilder.newBuilder().register(new PdprofResponseFilter()).property("client.ChunkingThreshold", 0);

		Client c = cb.build();
		String res = null;
		String text = "0123456789";
		for (int i=0; i<8; i++ ) {
			text = text + text;
		}
		Entity<Form> entity = Entity.entity(new Form().param("text", text).param("method", "post"),
			    MediaType.APPLICATION_FORM_URLENCODED_TYPE);
		
		MultivaluedMap<String, Object> headers = new MultivaluedHashMap<>();
		headers.putSingle("Expect", "100-continue");
		
		try {
			res = c.target("http://localhost:9080/jaxrs.client/snoops").request().headers(headers).post(entity, String.class);
		} catch (Exception e) {
			res = "[Error]:" + e.toString();
			System.out.println("*** JaxrsClientServlet ***");
			e.printStackTrace();
		} finally {
			c.close();
		}
		response.getWriter().append(res);
		System.out.println("*** JaxrsClientServlet END ***\n\n");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
