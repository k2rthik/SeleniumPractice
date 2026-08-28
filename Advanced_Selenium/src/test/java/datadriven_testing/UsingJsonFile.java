package datadriven_testing;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class UsingJsonFile
{
	public static JSONObject commonData;
	
	public static void main(String[] args) throws  IOException, ParseException
	{
		JSONParser parser = new JSONParser();
		String path = "C:\\Users\\broly\\OneDrive\\Desktop\\data\\commonData.json";
		//JSONObject commonData = null;
		
		try(FileReader reader = new FileReader(path))
		{
			commonData = (JSONObject) parser.parse(reader);
		}
		System.out.println(commonData.get("url"));	
	}
}
