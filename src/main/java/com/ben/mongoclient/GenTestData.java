package com.ben.mongoclient;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.google.gson.Gson;


public class GenTestData {
	
	public void generate(){
		
		
		
		try {
			
			
			File file = new File("/Users/AirWatch/test.txt");
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);	
		
		for(int i=0;i<1000000;i++){
			
			
			
		Gson g=new Gson();
		Device d=new Device();
		d.UDID=Integer.toString(1000000+i);
		d.FriendlyName=UUID.randomUUID().toString().replaceAll("-", "");
		d.sn=Integer.toString(Math.abs(UUID.randomUUID().toString().replaceAll("-", "").hashCode()));
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		d.ManDate = formatter.format(date);
		String content = g.toJson(d); 
	
			bw.write(content);
			bw.newLine();
			
 
			
 
		
		
		}
		System.out.println("Done");
		bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
	
	
		
	}

}
