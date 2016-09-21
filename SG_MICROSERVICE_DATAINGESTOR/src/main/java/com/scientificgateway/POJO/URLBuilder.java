package com.scientificgateway.POJO;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class URLBuilder {
	private Date date;
	private String NEXRADstation;
	private int time;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNEXRADstation() {
		return NEXRADstation;
	}

	public void setNEXRADstation(String nEXRADstation) {
		NEXRADstation = nEXRADstation;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

}
