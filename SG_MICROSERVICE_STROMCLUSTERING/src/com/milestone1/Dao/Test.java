package com.milestone1.Dao;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;

public class Test{
	
	public Test() {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(UriBuilder.fromUri("http://localhost:8080/SG_MICROSERVICE_STORMDETECTOR").build());
		String response=target.path("gateway").path("StormDetection").request().accept("application/xml").get(Response.class).toString();
		//String xmlAnswer =target.path("gateway").path("StormDetection").request().accept(MediaType.TEXT_XML).get(String.class);
		String xmlAnswer = target.path("gateway").path("StormDetection").request().accept("application/xml").get(String.class);
		System.out.println(response);
		System.out.println(xmlAnswer);
		System.out.println();
		setResponse1(xmlAnswer);
	}
	
	private String response1;
	public String getResponse1() {
		return response1;
	}

	public void setResponse1(String response1) {
		this.response1 = response1;
	}

	

	

}
