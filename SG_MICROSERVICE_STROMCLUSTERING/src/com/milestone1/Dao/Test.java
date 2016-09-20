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
		WebTarget target1 = client1.target("http://localhost:8080/SG_MICROSERVICE_STORMDETECTOR").path("gateway").path("StormDetection").path("send");
		System.out.println("WebTarget");
		//target1.queryParam("name1", "value1");
		
		Response response2 = target1.request().post(Entity.entity("hii", "application/xml"),Response.class);
		System.out.println(response2.toString());
		
	}
	
	private String response1;
	public String getResponse1() {
		return response1;
	}

	public void setResponse1(String response1) {
		this.response1 = response1;
	}

	

	

}
