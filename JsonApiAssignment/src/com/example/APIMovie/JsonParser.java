package com.example.APIMovie;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

public class JsonParser {
	
	final String url = "https://api.themoviedb.org/3/movie/";
	
	public String parseFor(String tag) {
		//JSONObject json = new JSONObject(readUrl("..."));
		return "";
	}
	
	
	
	
	
	
	
	
	
	
	
	private String getApiKey() {
		try {
			byte[] apiEncoded = Files.readAllBytes(Paths.get(""));
			return new String(apiEncoded, "UTF-8");
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
}
