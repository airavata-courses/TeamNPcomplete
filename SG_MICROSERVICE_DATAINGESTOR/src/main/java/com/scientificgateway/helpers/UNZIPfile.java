package com.scientificgateway.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class UNZIPfile {
	
	public void unzip(String gzipFile,String newFile){
		try {
	        FileInputStream fis = new FileInputStream(gzipFile);
	        GZIPInputStream gis = new GZIPInputStream(fis);
	        
	        File file=new File(newFile);
	        file.createNewFile();
	        FileOutputStream fos = new FileOutputStream(file);
	        byte[] buffer = new byte[1024];
	        int len;
	        while((len = gis.read(buffer)) != -1){
	            fos.write(buffer, 0, len);
	        }
	        //close resources
	        fos.close();
	        gis.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
}
