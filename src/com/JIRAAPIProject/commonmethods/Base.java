package com.JIRAAPIProject.commonmethods;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Base {

	@Test
	public void baseMethod(){
		RestAssured.baseURI="https://weather-ydn-yql.media.yahoo.com";
	given().
	param("location","sunnyvale").
	param("lat","37.372").
	param("lon", "-122.038").
	param("format", "json").
	param("woeid", "2502265").   
	when().
	get("/forecastrss").
	then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
	
	}
}
