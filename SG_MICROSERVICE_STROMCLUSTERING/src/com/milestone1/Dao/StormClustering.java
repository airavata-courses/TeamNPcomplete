package com.milestone1.Dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.milestone1.Service.StrormClusteringService;




@Path("/StormClustering")
public class StormClustering {
	
	private StrormClusteringService StrormClusteringService;
	
	@GET
	//@Path("/get")
	@Produces("application/xml")
	public String generateKML() throws ParseException {
		
		
		 
		Test test=new Test();
		
		
		 
		String dateString ="2015-03-03";
		String locationCode ="KABX"; 
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		//System.out.println(date);
		
		//String filevalue ="http://noaa-nexrad-level2.s3.amazonaws.com/2015/03/03/KABX/KABX20150303_001050_V06.gz";
		return "<KMLResponseFromStormClustering>" + "<year>" +  date + "</year>"+"<ResponseMessageFromPrevious>" +  test.getResponse1() + "</ResponseMessageFromPrevious>"+"<location>" +  locationCode + "</location>"+ "</KMLResponseFromStormClustering>";
	}
	
	

}
