package tests;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import org.apache.commons.io.IOUtils;   

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static org.hamcrest.Matchers.equalTo;;




public class SoapXMLRequest {
	
	// Create a class
		// Create a function and annotate with @Test(TestNG)
		// Add baseURI
		// for static import use - import static io.restassured.RestAssured.*
		// Provide headers and body
		// To get request body from a file 
		   //1. create a file with xml extension
		   //2. Copy the request body(From the website) and save the file
		   //3. Create a folder inside your project and save the file inside it
		   //4. Get the file in the code using fileInputStream - opens the file and reads it byte by byte
	    // Add Expected condition | Response Validation using freformatter
		  
	
	
	
	@Test
	public void validateSoapXML() throws IOException {
		File file = new File("./SOAPRequest/Add.xml");
		
		if(file.exists()) {
			System.out.println("File Exists");
		}
		FileInputStream fileInputStream = new FileInputStream(file);
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
		
		baseURI = "http://dneonline.com";
		
		given()
		.contentType("text/xml")
		.accept(ContentType.XML)
		.body(requestBody).
	    when()
	    .post("calculator.asmx").
	    then()
	    .statusCode(200).log().all()
	    .and()
		.body("//*:AddResult.text()", equalTo("15"));
	    
	   
		
		
	}

}
