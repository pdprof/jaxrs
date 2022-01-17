package pdprof.jaxrs.client;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;

public class PdprofResponseFilter implements ClientResponseFilter {

	@Override
	public void filter(ClientRequestContext arg0, ClientResponseContext arg1) throws IOException {
		System.out.println("******** PdprofResponseFilter START ******** ");
		System.out.println("Thread name : " + Thread.currentThread().getName());
		System.out.println("Status : " + arg1.getStatus());
		System.out.println("Length : " + arg1.getLength());
		System.out.println("InputStream : " + arg1.getEntityStream());
		System.out.println("******** PdprofResponseFilter END ******** \n\n");
	}

}
