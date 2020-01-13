package com.example.APIMovie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

public class JsonParser {
	
	final String apiUrl = "https://api.themoviedb.org/3/movie/";
	
	/*public MoviePacket parseForMovieFromID(String tag, int MovieID) {
	 
		JSONObject json = new JSONObject(readUrl(apiUrl,MovieID));
		return new MoviePacket();
	}*/
	public String readUrl(/*String url,*/ int MovieID) {
		String output = null;
		try {
			URL fullUrl = new URL(apiUrl + MovieID + "?api_key=" + getApiKey());
			BufferedReader bReader = new BufferedReader(new InputStreamReader(fullUrl.openStream(), "UTF-8"));
			
			StringBuilder sb = new StringBuilder();
			String sTemp = "";
			while ((sTemp = bReader.readLine()) != null) {
				sb.append(sTemp);
			}
			output = sb.toString();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return output;
	}
	private String getApiKey() {
		try {
			byte[] apiEncoded = Files.readAllBytes(Paths.get("C:/Users/AnimeDasho/eclipseee-workspace/apiKeyMovieDB.txt"));
			return new String(apiEncoded, "UTF-8");
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
}
