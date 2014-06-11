package com.ben.mongoclient;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;




public class ConfigManager {
		
	Properties prop = new Properties();
	private static ConfigManager singleton;
	CRUD db=null;
	
	public static ConfigManager get() {
		if(singleton==null){
		   singleton=new ConfigManager();
		}
		return singleton;
		
	}
	
	public CRUD connection(){
		String dbname=getDB();
		
		DBClient dbclient=new DBClient();
		db=dbclient.createObj(dbname);
		return db;
	}
	
	
	public void getConfigFile(){
		InputStream fin = ClassLoader.getSystemClassLoader().getResourceAsStream("config.properties");
		try{
			
	        prop.load(fin);
		}catch(IOException o){
			o.printStackTrace();
		}
	}

	
	
	public String getDB(){
		getConfigFile();
		String db=null;
		db=prop.getProperty("database");
		if(db!=null)
			return db;
		return "mongodb";
		
	}
}   
