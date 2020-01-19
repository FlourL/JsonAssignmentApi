package com.example.APIMovie;

import org.json.JSONObject;

public class SimpleParsingFunction implements ParsingFunction{

	@Override
	public Packet Parse(String jsonText) {
		SimpleMoviePacket packet = new SimpleMoviePacket();
		JSONObject json = new JSONObject(jsonText);
		packet.setTitle(json.getString("title"));
		packet.setID(json.getInt("id"));
		packet.setDesc(json.getString("description"));
		return packet;
	}

}
