package com.JIRAAPIProject.goodpractice;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.JIRAAPIProject.commonmethods.CommonFunctions;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JIRAAuthentication {
	@Test
	public  String authentication(){
		CommonFunctions cf = new CommonFunctions();
		RestAssured.baseURI = "http://localhost:8080";
		Response res =given()
		.header("Content-Type","application/json")
		.body("{ \"username\": \"priyamurali341\", \"password\": \"Kunapriya123@\" }")
		.when()
		.post("/rest/auth/1/session")
		.then().assertThat().statusCode(200).extract().response();
		
		JsonPath jp =cf.commonMethodsForJson(res);
		String sessionid =jp.get("session.value");
		System.out.println(sessionid);
		return sessionid;
		
		
	}

}

