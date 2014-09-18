package ku.ws.http;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import org.glassfish.jersey.client.ClientConfig;

public class JerseyHTTPClientPractice {
	public static final String DOMAIN_PATH = "http://openapi.naver.com";
	public static final String URL_PATH = DOMAIN_PATH + "/search?key=c1b406b32dbbbbeee5f2a36ddc14067f&query=%EC%A3%BC%EC%8B%9D&target=news&start=1&display=10";
	
	public static void getSimpleHTTP() {
//		ClientConfig clientConfig = new ClientConfig();
//		clientConfig.register(MyClientResponseFilter.class);
//		clientConfig.register(new AnotherClientFilter());
		 
		Client client = ClientBuilder.newClient();
//		client.register(ThirdClientFilter.class);
		 
		WebTarget webTarget = client.target(URL_PATH);
//		webTarget.register(FilterForExampleCom.class);
//		WebTarget resourceWebTarget = webTarget.path("resource");
//		WebTarget helloworldWebTarget = resourceWebTarget.path("helloworld");
//		WebTarget helloworldWebTargetWithQueryParam = helloworldWebTarget.queryParam("greeting", "Hi World!");
		 
//		Invocation.Builder invocationBuilder = helloworldWebTargetWithQueryParam.request(MediaType.TEXT_PLAIN_TYPE);
		
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML_TYPE);
		invocationBuilder.header("some-header", "true");
		Response response = invocationBuilder.get();
		System.out.println("Status Code: " + response.getStatus());
		System.out.println("Data: \n" + response.readEntity(String.class));
	}
	
	public static String getFluentHTTP() {
		Client client = ClientBuilder.newClient();
		String xmlStr = client.target(DOMAIN_PATH)
							.path("search")
							.queryParam("key", "c1b406b32dbbbbeee5f2a36ddc14067f")
							.queryParam("query", "%EC%A3%BC%EC%8B%9D")
							.queryParam("target", "news")
							.queryParam("start", "1")
							.queryParam("display", "10")
							.request(MediaType.APPLICATION_XML_TYPE)
							.header("some-header", "true")
							.get(String.class);
		//System.out.println(xmlStr);
		
		return xmlStr;
	}
	
}
