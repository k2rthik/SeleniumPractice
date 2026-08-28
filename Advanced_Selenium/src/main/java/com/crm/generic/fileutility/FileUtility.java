package com.crm.generic.fileutility;

import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileUtility
{
	public String getDataFromProperties(String key) throws Exception
	{
		//FileInputStream fs = new FileInputStream("./src/main/resources/config.properties");
		InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
		Properties prop = new Properties();
		prop.load(input);
		String data = prop.getProperty(key);
		return data;
	}
	
	public String getDataFromJson(String key) throws Exception
	{
		FileReader file = new FileReader("./src/main/resources/commonData.json");
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(file);
		JSONObject map = (JSONObject) obj;
		String data = (String) map.get(key);
		return data;
	}
}
