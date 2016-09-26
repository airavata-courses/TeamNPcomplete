package com.milestone1.Dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;

import com.milestone1.Service.StrormClusteringService;




@Path("/StormClustering")
public class StormClustering {
	
	private StrormClusteringService StrormClusteringService;
	
	@GET
	@Path("/get")
	@Produces("application/xml")
	public String generateKML(String xmlNewResponse) throws ParseException {
		
		
		 
		Test test=new Test();
		
		
		 
		String dateString ="2015-03-03";
		String locationCode ="KABX"; 
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		//System.out.println(date);
		
		//String filevalue ="http://noaa-nexrad-level2.s3.amazonaws.com/2015/03/03/KABX/KABX20150303_001050_V06.gz";
		return "<KMLResponseFromStormClustering>" + "<year>" +  date + "</year>"+"<ResponseMessageFromPrevious>" +  xmlNewResponse + "</ResponseMessageFromPrevious>"+"<location>" +  locationCode + "</location>"+ "</KMLResponseFromStormClustering>";
	}
	
	@POST
	@Path("/send")
	@Consumes("application/xml")
	public Response json(String xmlResponse) throws ParseException, JSONException {
		StormClustering sc=new StormClustering();
		String xmlNewResponse =xmlResponse;
		System.out.println("data is here" +xmlNewResponse);
		sc.generateKML(xmlNewResponse);
		System.out.println("DONE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return Response.status(200).entity(xmlNewResponse).build();		
	}
	
	

}
