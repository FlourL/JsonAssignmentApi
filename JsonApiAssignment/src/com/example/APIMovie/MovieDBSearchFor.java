package com.example.APIMovie;

import java.net.MalformedURLException;
import java.net.URL;

public class MovieDBSearchFor extends MovieDBReader{
	public MovieDBSearchFor(String movieName) {
		setFullURL(movieName);
	}
	private void setFullURL(String movieName) {
		try {
			this.fullURL = new URL(
					this.apiUrl +
					"/search/movie" + //path to search movie
					"?api_key=" + getApiKey() + //Adds API key
					"&language=en-US"+ //US language needed for search
					"&query =" + (movieName.replace(" ", "-").toLowerCase())+ //Searches for movie (adds hyphen and turns lower case)
					"&page=1" + // page numbers (optional)
					"&include_adult=false" //not sure actually
					);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
