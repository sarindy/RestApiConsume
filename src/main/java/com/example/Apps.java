package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Apps {

	public static void main(String[] args) throws JsonProcessingException {

		Model model = new Model(9, "Sarindy");

		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println(objectMapper.writeValueAsString(model));

		try {

			// create HTTP Client
			HttpClient httpClient = HttpClientBuilder.create().build();

			/*
			 * // Create new getRequest with below mentioned URL HttpGet getRequest = new
			 * HttpGet(
			 * "https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyDuT4HSoFBCQhBc-X0zyT5SkNTmDDjm4ho"
			 * );
			 * 
			 * // Add additional header to getRequest which accepts application/xml data
			 * getRequest.addHeader("accept", "application/json");
			 */

			/*
			 * HttpPost getRequest = new HttpPost(
			 * "https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyDuT4HSoFBCQhBc-X0zyT5SkNTmDDjm4ho"
			 * ); getRequest.addHeader("accept", "application/json");
			 */

			for (int i = 0; i < 1000; i++) {
				HttpPost request = new HttpPost("http://localhost:8080/api/authen/addRole");
				request.addHeader("Content-Type", "application/json;charset=utf8");

				String body = "{\"role\":\"ROLE+ " + i + "\"}";
				StringEntity entity = new StringEntity(body);

				request.setEntity(entity);

				// Execute your request and catch response
				HttpResponse response = httpClient.execute(request);

				// Check for HTTP response code: 200 = success
				if (response.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException(
							"Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
				}

				// Get-Capture Complete application/xml body response
				BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
				String output;
				String makeup = "";
				System.out.println("============Output:============");

				// Simply iterate through XML response and show on console.
				while ((output = br.readLine()) != null) {
					makeup += output;
					System.out.println(output);
				}

				//System.out.println(makeup);

			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
