package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JSONSchemaValidator {
	
	/*
	 * JSON Schema is a blueprint that checks whether an API’s JSON response has the
	 * correct structure and data types. It ensures every field (like id, name,
	 * email) is present and valid, so the frontend always receives proper,
	 * predictable data.
	 */
	
	
	// Create JSON Schema
	// Add JSON Schema file in classpath
	// Add maven dependency for JSON Schema Validator
	// Create a new function to validate json response against Schema
	
	   @Test
	    public void testGet() {
	        baseURI = "https://jsonplaceholder.typicode.com";
	        
	        given()
	        .when()
	            .get("/users")
	        .then()
	            .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"))
	            .statusCode(200);
	          
	    }

}
