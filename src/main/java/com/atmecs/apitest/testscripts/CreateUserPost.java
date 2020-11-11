package com.atmecs.apitest.testscripts;

import java.net.MalformedURLException;
import java.net.URL;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.atmecs.apitest.testdataprovider.UserDataProvider;

	public class CreateUserPost {

		@Test(dataProvider = "user", dataProviderClass = UserDataProvider.class)
		public void testCreateUser (Object requestbody) throws MalformedURLException {
			System.out.println("Request Body:" + requestbody);
			
			String requestUrl = "https://reqres.in/api/users";
			
			RequestSpecification request = RestAssured.given();
			Response response = request.body (requestbody.toString()).post(new URL(requestUrl)).then()
					.extract.response();
			
			int statusCode = response.getStatusCode();
			String responseBody = response.getBody().asString();
			
			System.out.println("Status Code:" + statusCode);
			System.out.println("responseBody:" + responseBody);
			
			Assert.assertEquals(statusCode, 201);
			
			JsonPath jsonPath = response.jsonPath();
			String name = jsonPath.getString("name");
			System.out.println("Name:" + name);
			
			JSONObject jsonObject = (JSONObject) requestbody;
			Assert.assertEquals(name, jsonObject.get("name"));
		}
	}

