package com.milestone1.beanParam;

import javax.ws.rs.QueryParam;


public class DataIngesterParamHolder {
	
	private @QueryParam("station") String NEXRADstation;
	private @QueryParam("date") String date;
	private @QueryParam("time") int time;

	public String getNEXRADstation() {
		return NEXRADstation;
	}

	public void setNEXRADstation(String nEXRADstation) {
		NEXRADstation = nEXRADstation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

}
