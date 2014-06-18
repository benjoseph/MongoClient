package com.ben.mongoclient;

import com.sun.istack.internal.logging.Logger;

/* Read 10,1000 records by searching for consecutive UDID and 
 * prints the time taken to complete the read process.
 */


public class ReadPerfTest {
	
	static Logger log=Logger.getLogger(ReadPerfTest.class);
	
	public void runtest(){
		
		//to obtain an instance of collection which can be used to perform crud
		ConfigManager config=ConfigManager.get();
		CRUD db=config.selectdbtype();
		db.createconn();
	
		
		long l1,l2;
		
		l1=System.currentTimeMillis();
		String UDID;
		log.info("Starting read test");
		for(int i=1010000;i<1020000;i++){
			
		       UDID = Integer.toString(i);
			   db.read(UDID);
//			   d.display();
		}
		l2=System.currentTimeMillis();
		log.info("Read time for 10,000 records is "+(l2-l1));
	}

}
