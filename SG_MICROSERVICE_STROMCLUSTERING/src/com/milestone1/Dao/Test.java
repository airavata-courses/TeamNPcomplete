package com.milestone1.Dao;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;






import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientResponse;


public class Test{
	
	public Test() {
		
		//HTTPget 
		//HttpGet request=new HttpGet("http://pro.ip-api.com/xml/"+entry.ip+"?key=zTbNOOuTjoBXLZu");
		
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(UriBuilder.fromUri("http://localhost:8080/SG_MICROSERVICE_STORMDETECTOR").build());
		//WebTarget target = client.target(UriBuilder.fromUri("http://localhost:8080/SG").build());
		String response=target.path("gateway").path("StormDetection").path("get").request().accept("application/xml").get(Response.class).toString();
		//String xmlAnswer =target.path("gateway").path("StormDetection").request().accept(MediaType.TEXT_XML).get(String.class);
		String xmlAnswer = target.path("gateway").path("StormDetection").path("get").request().accept("application/xml").get(String.class);
		System.out.println(response);
		System.out.println(xmlAnswer);
		System.out.println();
		setResponse1(xmlAnswer);
		
		
		
		
		ClientConfig config1 = new ClientConfig();
		System.out.println("ClientConfig config1 ");
		Client client1 = ClientBuilder.newClient(config1);
		System.out.println("Client client1 ");
		//http://ec2-54-69-92-137.us-west-2.compute.amazonaws.com:65000/forecast_decision/json
		//WebTarget target1 = client1.target("http://localhost:8080/SG_SC").path("gateway").path("StormDetection").path("send");
		WebTarget target1 = client1.target("http://ec2-54-69-92-137.us-west-2.compute.amazonaws.com:65000/forecast_decision").path("json");
		System.out.println("WebTarget");
		//target1.queryParam("name1", "value1");
		
		//Response response1 = target1.request().post(Entity.entity("hii", "application/xml"),Response.class);
		String responsefrom;
		responsefrom=target1.request().post(Entity.entity("hii", "application/xml"),String.class);
		System.out.println(response1.toString());
		System.out.println();
		System.out.println(responsefrom);
		
		
		
		/*ClientConfig config2 = new ClientConfig();
		Client client2 = ClientBuilder.newClient(config2);
		WebTarget target2 = client2.target(UriBuilder.fromUri("http://ec2-54-69-92-137.us-west-2.compute.amazonaws.com:65000/forecast_decision").build());
		//WebTarget target = client.target(UriBuilder.fromUri("http://localhost:8080/SG").build());
		String response2=target2.path("json").request().accept("application/json").get(Response.class).toString();
		//String xmlAnswer =target.path("gateway").path("StormDetection").request().accept(MediaType.TEXT_XML).get(String.class);
		String xmlAnswer2 = target2.path("json").request().accept("application/json").get(String.class);
		System.out.println(response2);
		System.out.println(xmlAnswer2);
		System.out.println();
		setResponse1(xmlAnswer);*/
		
	}
	
	private String response1;
	public String getResponse1() {
		return response1;
	}

	public void setResponse1(String response1) {
		this.response1 = response1;
	}

	

	

}
