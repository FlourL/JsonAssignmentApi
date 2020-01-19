package com.example.APIMovie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class MovieDBReader {
	protected final String apiUrl = "https://api.themoviedb.org/3";
	protected URL fullURL;
	
	public String readUrl() {
		String output = null;
		try {
			BufferedReader bReader = new BufferedReader(new InputStreamReader(this.fullURL.openStream(), "UTF-8"));
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
	protected String getApiKey() {
		try {
			byte[] apiEncoded = Files.readAllBytes(Paths.get("C:/Users/AnimeDasho/eclipseee-workspace/apiKeyMovieDB.txt"));
			return new String(apiEncoded, "UTF-8");
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public URL getFullURL() {
		return fullURL;
	}
	public void setFullURL(URL fullURL) {
		this.fullURL = fullURL;
	}
	
}
