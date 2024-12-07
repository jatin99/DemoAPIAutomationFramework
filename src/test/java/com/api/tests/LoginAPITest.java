package com.api.tests;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest {

	@Test(description = "Verify if Login API is working...")
	public void loginTest() {
		RestAssured.baseURI="http://64.227.160.186:8080";
		RequestSpecification x =RestAssured.given();
		RequestSpecification y =x.header("Content-Type", "application/json");
		RequestSpecification z=y.body("{\"username\": \"uday1234\",\"password\": \"uday1234\"}");
		Response response=z.post("/api/auth/login");
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 2112);
	}
}
