package com.space.client;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.List;

public class OpenNotifyClient {
	private static final String NOTIFY_URL = "http://api.open-notify.org/astros.json";

	public static void main(String[] args) {
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) new URL(NOTIFY_URL).openConnection();
			connection.setRequestMethod("GET");
			ObjectMapper mapper = new ObjectMapper();
			Response response = mapper.readValue(connection.getInputStream(), Response.class);
			if (response != null && response.getPeople() != null) {
				printResponse(response.getPeople());
			}
		} catch (Exception ex) {
			System.out.println("Exception: " + ex);
		} finally {
			connection.disconnect();
		}
	}

	private static void printResponse(List<Person> people) {
		int maxLen = people.stream().map(p -> p.getName()).max(Collections.reverseOrder()).get().length();
		// sort by craft/ last name
		Collections.sort(people);
		String fieldsStr = "Name";
		String line = "____";
		// Ensure that the width of the header is as long as the longest value in the column.
		while (fieldsStr.length() < maxLen) {
			fieldsStr += " ";
			line += "_";
		}
		fieldsStr += "|" + "Craft";
		line += "|_____";
		System.out.println(fieldsStr);
		System.out.println(line);
		String prevCraft = "";
		for (Person p : people) {
			String name = p.getName();
			while (name.length() < maxLen) {
				name += " ";
			}
			// Don’t repeat the name of the craft—group all people by craft.
			String craftStr = prevCraft.equals(p.getCraft()) ? "" : p.getCraft();
			System.out.println(name + "|" + craftStr);
			prevCraft = p.getCraft();
		}
	}
}
