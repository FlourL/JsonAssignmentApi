package com.example.APIMovie;

public class JsonParser {
	
	public Packet parseStringWith(String jsonText, ParsingFunction pFunction) {
		Packet packet = pFunction.Parse(jsonText);
		return packet;
	}
}

