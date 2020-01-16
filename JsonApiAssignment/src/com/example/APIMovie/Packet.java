package com.example.APIMovie;

public abstract class Packet {
	public String getClassName() {
		return this.getClass().getName().toString();
	}
}
