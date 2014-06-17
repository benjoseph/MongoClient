package com.ben.mongoclient;


/*Used to create an connection object specific to database
 * 
 */

public interface DBFactory {
	
	public CRUD createObj(String db);

}
