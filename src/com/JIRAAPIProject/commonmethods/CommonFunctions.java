package com.JIRAAPIProject.commonmethods;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class CommonFunctions {
    public XmlPath commonMethodsForXml(Response rs){
    	String respo =rs.asString();
		System.out.println(respo);
		XmlPath xp = new XmlPath(respo);
		return xp;
    }
    public JsonPath commonMethodsForJson(Response rs){
		String respo=rs.asString();
		System.out.println(respo);
		JsonPath jsp = new JsonPath(respo);
    	return jsp;
    	
    }
}
