package com.milestone1.Dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	public String generateKML() throws ParseException {
		 
		String dateString ="2015-06-06";
		String locationCode ="KABX"; 
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		//System.out.println(date);
		
		String filevalue ="http://noaa-nexrad-level2.s3.amazonaws.com/2015/03/03/KABX/KABX20150303_001050_V06.gz";
		
 
		String result = "@Produces(\"application/xml\")" + "\n\n"
				+ "Output:\n\n Example KML, we can add tags here " + "\n\n" 
				+ "\n\n URL for file is " +filevalue+ "\n\n" 
				+ " use this for download \n\n";
		
		return "<KMLResponseFromStormDetector>" + "<year>" +  date + "</year>" + "<location>" +  locationCode + "</location>"+ "<filename>" + result + "</filename>" + "</KMLResponseFromStormDetector>";
	}
	@POST
	@Path("/send")
	@Consumes("application/xml")
	public Response KML(String data) throws ParseException {
		 
		/*String dateString ="2015-06-06";
		String locationCode ="KABX"; 
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		String filevalue ="http://noaa-nexrad-level2.s3.amazonaws.com/2015/03/03/KABX/KABX20150303_001050_V06.gz";
		*/
		System.out.println("data is here" +data);
		return Response.status(200).entity(data).build();
		
		
	}
	/*@POST
	@Path("/sendjson")
	@Consumes("application/json")
	public Response json(JSONObject obj) throws ParseException, JSONException {
		 
		String dateString ="2015-06-06";
		String locationCode ="KABX"; 
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		String filevalue ="http://noaa-nexrad-level2.s3.amazonaws.com/2015/03/03/KABX/KABX20150303_001050_V06.gz";
		
		System.out.println("data is here" +obj.getString("reqId"));
		return Response.status(200).entity(obj.getString("reqId")).build();
		
		
	}*/
	
}
	