package com.milestone1.Service;

public class DataIngesterService {
	public String returnBuiltURL(String date,int time,String NEXRADname ){
		return " https://aws.amazon.com/noaa-big-data/nexrad/"+"/"+date+"/"+time+"/"+NEXRADname;
	}
}
