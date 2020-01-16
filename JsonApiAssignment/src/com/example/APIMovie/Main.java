package com.example.APIMovie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
	final static String apiUrl = "https://api.themoviedb.org/3/movie/";
	public static void main(String[] args) {
		JsonParser parser = new JsonParser();
		
		SimpleMoviePacket packet = (SimpleMoviePacket) parser.parseStringWith(readUrl("550"), new SimpleParsingFunction());
		System.out.println("Title: " + packet.getTitle());
		System.out.println("ID: " + packet.getID());
	}
	public static String readUrl(String conditions) {
		String output = null;
		try {
			URL fullUrl = new URL(apiUrl + conditions + "?api_key=" + getApiKey());
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
	private static String getApiKey() {
		try {
			byte[] apiEncoded = Files.readAllBytes(Paths.get("C:/Users/AnimeDasho/eclipseee-workspace/apiKeyMovieDB.txt"));
			return new String(apiEncoded, "UTF-8");
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
