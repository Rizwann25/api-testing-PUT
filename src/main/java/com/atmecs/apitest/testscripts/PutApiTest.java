package com.atmecs.apitest.testscripts;

import java.net.MalformedURLException;
import java.net.URL;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

	public class PutApiTest {

		@Test
		public void testPutUser() throws MalformedURLException {
			String requestUrl = "https://reqres.in/api/users/2";
			
			RequestSpecification request = RestAssured.given();
			Response response = request.Put(new URL(requestUrl)).then().extract().response();
			
			int statusCode = response.getStatusCode();
			
			Assert.assertEquals(statusCode, 204);
			
			System.out.println("Status Code --" + statusCode);
			
		}
	}

