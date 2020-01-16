package com.example.APIMovie;

public class Main {
	public static void main(String[] args) {
		JsonParser parser = new JsonParser();
		MovieDBReader mdr = new MovieDBSearchFor("Cloud Atlas"); //Basically Factory Pattern, just have no factory here yet.
		
		SimpleMoviePacket packet = new SimpleMoviePacket(); //need to rework to use multiple types of "Packets"
		packet = (SimpleMoviePacket) parser.parseStringWith(mdr.readUrl(), new SimpleParsingFunction());
		
		System.out.println("Title: " + packet.getTitle());
		System.out.println("ID: " + packet.getID());
	
	}
}
