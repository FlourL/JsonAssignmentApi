package com.example.APIMovie;

import org.json.JSONArray;
import org.json.JSONObject;

public class SimpleParsingFunction implements ParsingFunction{

	@Override
	public Packet Parse(String jsonText) {
		SimpleMoviePacket packet = new SimpleMoviePacket();
		JSONObject Superjson = new JSONObject(jsonText);
		JSONArray jsonA = Superjson.getJSONArray("results");
		for(Object o: jsonA) {
			JSONObject json = (JSONObject) o;
			packet.setTitle(json.getString("title"));
			packet.setID(json.getInt("id"));
			packet.setDesc(json.getString("overview"));
		};
		return packet;
	}

}
