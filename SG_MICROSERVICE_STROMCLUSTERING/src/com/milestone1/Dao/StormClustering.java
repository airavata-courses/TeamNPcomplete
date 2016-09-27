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

		Test test = new Test();

		return "<KMLResponseFromStormClustering>" + "<ResponseMessageFromPrevious>" + xmlNewResponse
				+ "</ResponseMessageFromPrevious>" + "</KMLResponseFromStormClustering>";
	}

	@POST
	@Path("/send")
	@Consumes("application/xml")
	public Response json(String xmlResponse) throws ParseException, JSONException {
		StormClustering sc = new StormClustering();
		String xmlNewResponse = xmlResponse;
		System.out.println("data in Clustering" + xmlNewResponse);
		sc.generateKML(xmlNewResponse);
		System.out.println("DONE!!!!!!!!!!!!!!!!!!!!!!");
		return Response.status(200).entity(xmlNewResponse).build();
	}

}
