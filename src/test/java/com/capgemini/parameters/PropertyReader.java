package com.capgemini.parameters;


import java.io.FileReader;
import java.util.Properties;

public class PropertyReader {
static String value;
	public static String getPropertyData(String propertyPath, String key ) {
		try {
			FileReader reader = new FileReader(propertyPath);
			Properties prop = new Properties();
			prop.load(reader);
			value = prop.getProperty(key);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if(value == null) {
			System.out.println("JSON object is null. Please check the file path or content");
			return null;
		}
		else {
			return value;
		}
	}
}
