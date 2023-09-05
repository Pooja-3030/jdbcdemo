package com.dnb.jdbcdemo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

public class DBUtils {
	
	private static Properties properties;
	private static Properties getProperties() {
		//inputStream is used to read input from a file, clasloader() method is used to load the data present in the file.
		InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("application.properties");
		try {
			// We are checking whether the inpuStream is null and showing the output.
			if(inputStream!=null) {
				properties = new Properties();
				// We are loading the inputStream into properties
				properties.load(inputStream);
				return properties;
			}
			else {
				return null;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(inputStream==null);
		return properties;
		
	}
	public static Optional<Connection> getConnection() {
		
		Properties properties = getProperties();
		try {
			Connection connection= DriverManager.getConnection(properties.getProperty("jdbc.url"), properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password"));
			return Optional.of(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
		
	}
	public static void closeConnection(Connection connection) {
		try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	}
	

}
