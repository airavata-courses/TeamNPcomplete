package com.milestone1.Dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.json.JSONException;
import org.json.JSONObject;

import com.milestone1.Service.StormDetectionService;

@Path("/StormDetection")
public class StromDetection {
	private StormDetectionService stormDetectionService;
	JsonCreation json=new JsonCreation();
	@GET
	//@POST
	@Path("/get")
	@Produces("application/xml")
	public String generateKML(String newUrl) throws ParseException {
		StromDetection sd=new StromDetection();
		String dateString ="2015-06-06";
		sd.sendURL("KABX");
		String locationCode ="KABX"; 
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		//System.out.println(date);
		
		String filevalue ="http://noaa-nexrad-level2.s3.amazonaws.com/2015/03/03/KABX/KABX20150303_001050_V06.gz";
		
 
		String result = "@Produces(\"application/xml\")" + "\n\n"
				+ "Output:\n\n Example KML, we can add tags here " + "\n\n" 
				+ "\n\n URL for file is " +filevalue+ "\n\n" 
				+ " use this for download \n\n";
		
		return "<KMLResponseFromStormDetector>" + "<newUrl>" +  newUrl + "</newUrl>" + "<location>" +  locationCode + "</location>"+ "<filename>" + result + "</filename>" + "</KMLResponseFromStormDetector>";
	}
	/*@POST
	@Path("/send")
	@Consumes("application/xml")
	public Response KML(String data) throws ParseException {
		 
		String dateString ="2015-06-06";
		String locationCode ="KABX"; 
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		String filevalue ="http://noaa-nexrad-level2.s3.amazonaws.com/2015/03/03/KABX/KABX20150303_001050_V06.gz";
		
		System.out.println("data is here" +data);
		return Response.status(200).entity(data).build();
		
		
	}*/
	
	
	@POST
	@Path("/send")
	@Consumes("application/xml")
	public Response json(String url) throws ParseException, JSONException {
		StromDetection sd=new StromDetection();
		String newUrl =url;
		System.out.println("data is here" +newUrl);
		String KML=sd.generateKML(newUrl);
		sd.sendURL(KML);
		return Response.status(200).entity(newUrl).build();		
	}
	
	public String sendURL(String url) {
		ClientConfig config1 = new ClientConfig();
		System.out.println("ClientConfig config1 ");
		Client client1 = ClientBuilder.newClient(config1);
		System.out.println("Client client1 ");
		//http://ec2-54-69-92-137.us-west-2.compute.amazonaws.com:65000/forecast_decision/json
		//WebTarget target1 = client1.target("http://localhost:8080/SG_SC").path("gateway").path("StormDetection").path("send");
		//WebTarget target1 = client1.target("http://local:8080/SG_MICROSERVICE_STROMCLUSTERING").path("gateway").path("StormClustering").path("send");
		WebTarget target1 = client1.target("http://localhost:8080/SG_MICROSERVICE_STROMCLUSTERING/gateway/StormClustering").path("send");
		System.out.println("WebTarget in detector");
		//target1.queryParam("name1", "value1");
		
		Response response = target1.request().post(Entity.entity(url,"application/xml"),Response.class);
		String responsefrom;
		responsefrom=target1.request().post(Entity.entity(url,"application/xml"),String.class);
		System.out.println(response.toString());
		System.out.println();
		System.out.println(responsefrom);
		return url;
		
		
	}
	
	
	
	
	
	
	
}
	