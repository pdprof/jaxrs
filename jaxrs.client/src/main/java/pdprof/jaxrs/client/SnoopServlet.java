package pdprof.jaxrs.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SnoopServlet
 */
@WebServlet("/snoop")
public class SnoopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SnoopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("******** SNOOP START ********");
		String body = "";
		Enumeration<String> i = request.getHeaderNames();
		String header = i.nextElement();
		while(i.hasMoreElements()) {
			String value = request.getHeader(header);
			body = body + header + ": " + value + "</br>\n";
			header = i.nextElement();
		}
		body = body + "Content-Length: " + request.getContentLength() + "</br>\n";
		body = body + "Transfer-Encoding: " + request.getHeader("Transfer-Encoding") + "</br>\n";
		body = body + "Client Port - getRempotePort(): "  + request.getRemotePort() + "</br>\n";;

		PrintWriter out = response.getWriter();
		out.println("<HTML><BODY>\n\n");
		out.println(body);
		System.out.println(body);
		out.println("\n\n</BODY></HTML>");
		System.out.println("******** SNOOP END ******** \n\n");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
