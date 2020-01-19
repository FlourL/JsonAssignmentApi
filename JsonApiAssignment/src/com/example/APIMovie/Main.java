package com.example.APIMovie;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		JsonParser parser = new JsonParser();
		Scanner scan = new Scanner(System.in);
		System.out.println("type in a moviename:");
		MovieDBReader mdr = new MovieDBSearchFor(scan.nextLine()); //Basically Factory Pattern, just have no factory here yet.
		
		SimpleMoviePacket packet = new SimpleMoviePacket(); //need to rework to use multiple types of "Packets"
		packet = (SimpleMoviePacket) parser.parseStringWith(mdr.readUrl(), new SimpleParsingFunction());
		System.out.println("Title: " + packet.getTitle());
		System.out.println("MovieDBID: " + packet.getID());
		System.out.println("Description: " + packet.getDesc());
	}
}
