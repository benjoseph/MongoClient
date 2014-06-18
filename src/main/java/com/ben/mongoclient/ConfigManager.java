package com.ben.mongoclient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* This class is used to read from properties file, which is used 
 * to determine the type of database use. ConfigManager is a singleton class.
 */

public class ConfigManager {

	private static ConfigManager singleton;
	Properties prop = new Properties();

	// To create singleton
	public static ConfigManager get() {
		if (singleton == null) {
			singleton = new ConfigManager();
		}
		return singleton;
	}

	// Create a connection to database
	public CRUD selectdbtype() {
		CRUD db = null;
		String dbtype = getDB();
		DBClient dbclient = new DBClient();
		db = dbclient.createObj(dbtype);
		return db;
	}

	// Load config file
	public void getConfigFile() {
		InputStream fin = ClassLoader.getSystemClassLoader()
				.getResourceAsStream("config.properties");
		try {

			prop.load(fin);
		} catch (IOException o) {
			o.printStackTrace();
		}
	}

	// Read config file after loading
	public String getDB() {
		getConfigFile();
		String db = null;
		db = prop.getProperty("database");
		if (db != null)
			return db;
		return "mongodb";

	}
}
