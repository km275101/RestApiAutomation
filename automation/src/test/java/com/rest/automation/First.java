package com.rest.automation;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.rest.automation.action.Initializer;

public class First extends Initializer{
	
	
	
	
	@Test
	public static void searchLocation() throws Exception {
		String uri = prop.getProperty("baseURI").toString();
		try {
			RestAssured.baseURI = prop.getProperty("baseURI");
			
			given().
			       param("location", "-33.8670522,151.1957362").
			       param("radius", "500").
			       param("type", "restaurant").
			       param("key", "AIzaSyBaOcaOAlbAtm-bH0NQgmpMmjH6Txlo8QA"). //AIzaSyD4hxiEeZ-LnO_BuO4XCbbK06L2XlNalIg
			when().
					get("maps/api/place/nearbysearch/json").
			then().assertThat().statusCode(200).and().
					contentType("application/json").and().
					body("results[0].name", equalTo("Blue Eye Dragon Taiwanese Restaurant"));
			System.out.println("Executed succesfully");
			
		} catch (Exception e) {
			throw e;
		}
		
	}
    
}
