package com.scientificgateway.helpers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadGZFile {
	private BufferedInputStream in;
	public String downloadFile(String url) throws IOException{
		URL localurl = new URL(url);
	    URLConnection con = localurl.openConnection();
	    
	    try{
	    	in = new BufferedInputStream(con.getInputStream());
	    }catch(FileNotFoundException e){
	    	System.out.println("inside exception");
	    	return "xxx";
	    }
	    
	    File myfile=new File("WeatherDataBinary.gz");
	    myfile.createNewFile();
	    FileOutputStream out = new FileOutputStream(myfile,false);

	    int i = 0;
	    byte[] bytesIn = new byte[3000000];
	    while ((i = in.read(bytesIn)) >= 0) {
	        out.write(bytesIn, 0, i);
	    }
	    out.close();
	    in.close();
		
		return "WeatherDataBinary.gz";
	}
	
}
