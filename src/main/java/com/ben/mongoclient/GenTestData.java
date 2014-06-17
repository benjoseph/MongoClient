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

/*Used to generate Test data to be inserted into the database.
 * The following fields are generated. All are converted to string later.
 * 1.UDID - A number used to index. Starts from 1,000,000.
 * 2.Friendly Name - Alphanumeric string
 * 3.Serial Number - Numeric string
 * 4.Manufacturing date - Current time
 */

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
				d.setUdid(Integer.toString(1000000+i));
				d.setFriendlyName(UUID.randomUUID().toString().replaceAll("-", ""));
				d.setSerialNumber(Integer.toString(Math.abs(UUID.randomUUID().toString().replaceAll("-", "").hashCode())));
				Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date=new Date();
				d.setManfDate(formatter.format(date));
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
