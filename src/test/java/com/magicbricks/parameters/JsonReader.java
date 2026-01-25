package com.magicbricks.parameters;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader {
static String value;
	public static String getJsonData(String jsonpath, String key) {
		JSONParser parser = new JSONParser();
		try {
			FileReader jsonfile = new FileReader(jsonpath);
			Object obj = parser.parse(jsonfile);
			JSONObject jsonobject = (JSONObject) obj;
			value = (String) jsonobject.get(key);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		if(value == null)
		{
			System.out.println("JSON object is null. Please check the file path or content");
			return null;
		}
		else
		{
			return value;
		}	
	}
}
