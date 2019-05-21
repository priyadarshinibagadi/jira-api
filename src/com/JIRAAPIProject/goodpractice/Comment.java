package com.JIRAAPIProject.goodpractice;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.JIRAAPIProject.commonmethods.CommonFunctions;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Comment {
	@Test
	public static void addComment() throws IOException{
		CommonFunctions cf = new CommonFunctions();
		JIRAAuthentication jira = new JIRAAuthentication();
		String postdata=generateStringFromResource("C:\\Users\\New User\\Desktop\\comment.json");
		RestAssured.baseURI = "http://localhost:8080";
		Response res=given()
		.header("Content-Type","application/json")
		.header("Cookie","JSESSIONID="+jira.authentication())
		.body(postdata).
		when()
		.post("/rest/api/2/issue/"+CreateIssue.createAnIssue()+"/comment")
		.then().assertThat().statusCode(201).extract().response();
		JsonPath jp = cf.commonMethodsForJson(res);
		String id = jp.get("id");
		System.out.println(id);
		
		
	}
	public static String generateStringFromResource(String path) throws IOException{
		return new String(Files.readAllBytes(Paths.get(path)));
		
	}

}
