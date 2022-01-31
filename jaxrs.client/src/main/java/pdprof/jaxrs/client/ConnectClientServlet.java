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
 * Servlet implementation class ConnectClientServlet
 */
@WebServlet("/connect")
public class ConnectClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("*** ConnectClientServlet START ***");
		String timeout = request.getParameter("timeout");
		String sleep = request.getParameter("sleep");
		String port = request.getParameter("port");
		try { Integer.parseInt(timeout); } catch (Exception e) { timeout = "10000";}
		try { Integer.parseInt(sleep); } catch (Exception e) { sleep = "10000";}
		try { Integer.parseInt(port); } catch (Exception e) { port = "9080";}
		String host = request.getParameter("host");
		if (host == null) { host = "localhost"; }
		
		ClientBuilder cb = ClientBuilder.newBuilder().register(new PdprofResponseFilter()).property("com.ibm.ws.jaxrs.client.connection.timeout", timeout);

		Client c = cb.build();
		String res = null;
		Entity<Form> entity = Entity.entity(new Form().param("time", sleep).param("method", "post"),
			    MediaType.APPLICATION_FORM_URLENCODED_TYPE);
		
		MultivaluedMap<String, Object> headers = new MultivaluedHashMap<>();
		headers.putSingle("Expect", "100-continue");
		
		try {
			res = c.target("http://"+ host + ":" + port + "/jaxrs/pdprof/sleep").request().headers(headers).post(entity, String.class);
		} catch (Exception e) {
			res = "[Error]:" + e.toString();
			System.out.println("*** ConnectClientServlet ***");
			e.printStackTrace();
		} finally {
			c.close();
		}
		response.getWriter().append(res);
		System.out.println("*** ConnectClientServlet END ***\n\n");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
