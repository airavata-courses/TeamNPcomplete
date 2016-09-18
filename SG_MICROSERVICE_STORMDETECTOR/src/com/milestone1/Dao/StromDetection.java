package com.milestone1.Dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.milestone1.Service.StormDetectionService;

@Path("/StormDetection")
public class StromDetection {
	private StormDetectionService stormDetectionService;
	
	@GET
	@Produces("application/xml")
	public String generateKML() throws ParseException {
		 
		String dateString ="2015-06-06";
		String locationCode ="KABX"; 
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		//System.out.println(date);
		
		String filevalue ="http://noaa-nexrad-level2.s3.amazonaws.com/2015/03/03/KABX/KABX20150303_001050_V06.gz";
		
 
		String result = "@Produces(\"application/xml\") \n\n"
				+ "Output:\n\n Example KML,we can add tags here\n\n" 
				+ "\n\n filename is" +filevalue+ "use this for download \n\n";
		return "<exampleKmlRoot>" + "<year>" +  date + "</year>" + "<location>" +  locationCode + "</location>"+ "<filename>" + result + "</filename>" + "</exampleKmlRoot>";
	}
}
	