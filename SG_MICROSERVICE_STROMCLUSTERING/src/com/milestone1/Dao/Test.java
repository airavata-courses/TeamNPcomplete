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
		
		MessageToForecast msg=new MessageToForecast();
		msg.setReqId(10);
    	msg.setUserId("soumya");
		
		
		
		ClientConfig config1 = new ClientConfig();
		//System.out.println("ClientConfig config1 ");
		Client client1 = ClientBuilder.newClient(config1);
		//System.out.println("Client client1 ");
		WebTarget target1 = client1.target("http://ec2-54-69-92-137.us-west-2.compute.amazonaws.com:65000/forecast_decision").path("json");
		System.out.println("WebTarget");
		
		
		//Response response1 = target1.request().post(Entity.entity("hii", "application/xml"),Response.class);
		String responsefrom;
		responsefrom=target1.request().post(Entity.entity(msg, "application/json"),String.class);
		//System.out.println(response1.toString());
		System.out.println();
		System.out.println(responsefrom);
		
		/**************************/
		
		
	}
	
	private String response1;
	public String getResponse1() {
		return response1;
	}

	public void setResponse1(String response1) {
		this.response1 = response1;
	}

	

	

}
