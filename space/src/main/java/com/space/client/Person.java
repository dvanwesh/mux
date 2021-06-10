package com.space.client;

public class Person implements Comparable<Person> {
	private String name;
	private String craft;

	public Person() {
	}

	public Person(String name, String craft) {
		this.name = name;
		this.craft = craft;
	}

	public String getName() {
		return name;
	}

	public String getCraft() {
		return craft;
	}


	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", craft='" + craft + '\'' +
				'}';
	}

	@Override
	public int compareTo(Person other) {
		return this.getCraft().equals(other.getCraft()) ?
				this.getName().split(" ", 2)[1].compareTo(other.getName().split(" ", 2)[1])
				: this.getCraft().compareTo(other.getCraft());
	}
}
