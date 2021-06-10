package com.space.client;

import java.util.List;

public class Response {
	private int number;
	private String message;
	private List<Person> people;

	public Response() {
	}

	public Response(int number, String message, List<Person> people) {
		this.number = number;
		this.message = message;
		this.people = people;
	}

	public int getNumber() {
		return number;
	}

	public String getMessage() {
		return message;
	}

	public List<Person> getPeople() {
		return people;
	}

	@Override
	public String toString() {
		return "Response{" +
				"number=" + number +
				", message='" + message + '\'' +
				", people=" + people +
				'}';
	}
}
