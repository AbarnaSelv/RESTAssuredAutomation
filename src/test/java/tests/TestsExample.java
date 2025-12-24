package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class TestsExample {
	
	@Test
	public void test1() {
		Response response =	get("https://jsonplaceholder.typicode.com/users");
		System.out.println(response.getStatusCode()); //200 means success 
		System.out.println(response.getTime()); // how long the request took
		System.out.println(response.getBody().asString()); // full JSON response
		System.out.println(response.getStatusLine()); //like HTTP/1.1 200 OK
		System.out.println(response.getHeader("content-type")); //like application/json; charset=utf-8, to get the type of the content whether it is a json
		
		int statusCode = response.getStatusCode(); 
		Assert.assertEquals(statusCode, 200);
		
	}
	
	@Test
	public void test2() { // BDD Style 
		baseURI = "https://jsonplaceholder.typicode.com";
		given().
		  get("/users").
		then().
		  statusCode(200).
		  body("[3].name", equalTo("Patricia Lebsack"))
		  .log().all(); // to get the complete response to be printed
		
	}

}
