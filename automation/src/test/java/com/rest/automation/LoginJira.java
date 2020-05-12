package com.rest.automation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.rest.automation.action.Initializer;
import com.rest.automation.action.CommonAction;
import com.rest.automation.utility.Resources;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LoginJira extends Initializer {
	public String session ;
	
	@Test(priority =0)
	public void searchLocation() throws Exception {
		
		String uri = prop.getProperty("JiraLogin").toString();
		String reqBody = comAct.generateString("LoginJira.json");
		
		try {
			RestAssured.baseURI = uri;
			Response r = 
			given().
			contentType(ContentType.JSON).
					body(reqBody).
			when().
					post(comAct.resourceLoginJira).
			then().
					assertThat().statusCode(200).
					extract().response();
			System.out.println("Executed succesfully");
		//	System.out.println(r.asString());
			
			JsonPath jes = new JsonPath(r.asString());
			session = jes.getString("session.value");
			
			System.out.println("Session id : "+session.toString());
			
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	@Test(priority =1)
	public void createIssue() throws Exception {
		
		String uri = prop.getProperty("JiraLogin").toString();
		String reqBody = comAct.generateString("CreateIssue.json");
		
		try {
			RestAssured.baseURI = uri;
			/*Response r = */
			given().
			contentType(ContentType.JSON).
					header("cookie", "JSESSIONID="+session+"").
					body(reqBody).
					
			when().
					post(comAct.createIssue).
					
			then().
					assertThat().statusCode(201);					
			
			
		} catch (Exception e) {
			throw e;
		}
		
	}

}
