package com.ben.mongoclient;

/*Used to create an connection object specific to database
 * 
 */


public class DBClient implements DBFactory {

	public enum dbenum {mongodb, redis, cassandra }
	dbenum dbtype;

	public CRUD createObj(String dbname) {

		dbtype=dbenum.valueOf(dbname);
		CRUD dbclient; 
		switch(dbtype){

		case mongodb: dbclient=new MongoCRUD();
		break;
		case redis: dbclient=new MongoCRUD();
		break;
		case cassandra:dbclient=new MongoCRUD();
		break;

		default:dbclient=null;

		}
		return dbclient;		
	}
	public DBClient(){

	}

}
