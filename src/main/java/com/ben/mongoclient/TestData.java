package com.ben.mongoclient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

/*Used to insert test data. Input file in JSON, each record in new line,placed in C:texts
 * 
 */
public class TestData {

	public void insert() {
		long l1,l2,time;
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\test.txt")))
		{
			ConfigManager conf=ConfigManager.get();
			CRUD m=conf.selectdbtype();
			m.createconn();

			Gson g=new Gson();
			String sCurrentLine;
			Device d;

			l1=System.currentTimeMillis();
			while ((sCurrentLine = br.readLine()) != null) {
				d=g.fromJson(sCurrentLine, Device.class);
				m.create(d);


			}
			l2=System.currentTimeMillis();
			time=l2-l1;
			System.out.println("Time taken for insertion is "+time);

		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}
