package com.scientificgateway.milestone1;

import java.io.IOException;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.scientificgateway.BeanParams.DataIngesterParamHolder;
import com.scientificgateway.servicelayer.DataIngesterService;

@Path("/dataingester")
public class DataIngester {

	private DataIngesterService DIservice;

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String returnURL(@BeanParam DataIngesterParamHolder dip) throws IOException {

		DIservice = new DataIngesterService();
		String url = DIservice.returnResponseFile(dip.getStation(), dip.getDate(), dip.getHours(), dip.getMinutes(),
				dip.getSeconds());
		System.out.println("in controller " + ": " + url);
		return url;

	}

}
