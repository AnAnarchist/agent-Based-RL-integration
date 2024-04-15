package gym.rest;

import java.util.Map;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@SuppressWarnings("unchecked")
public class GymRest<T> {
	
	public static String TARGET = "http://localhost:5003/env/";
	
	private Client client = ClientBuilder.newClient();
	private String envName; 

	public StateRest<T> initialize(String envName, Map<String, String> parameters) {
		