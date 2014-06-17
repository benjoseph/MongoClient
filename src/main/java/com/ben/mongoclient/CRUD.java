package com.ben.mongoclient;

/* 
 * Interface for DB specific operations.
 */


public interface CRUD {

	public boolean createconn();
	public boolean create(Device d);
	public Device read(String UDID);
	public boolean delete(String UDID);
	public boolean update(Device d);


}
