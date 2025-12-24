package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class XMLSchemaValidator {
	
	// see Fix XSD Error in chatgpt for more info

    @Test
    public void schemaValidation() throws IOException { 
    	
    	

        File file = new File("./SOAPRequest/Add.xml");
        FileInputStream fileInputStream = new FileInputStream(file);
        String requestBody = IOUtils.toString(fileInputStream, "UTF-8");

        baseURI = "http://dneonline.com";

        String innerXML =
                given()
                        .contentType("text/xml")
                        .accept(ContentType.XML)
                        .body(requestBody)
                .when()
                        .post("calculator.asmx")
                .then()
                        .statusCode(200)
                        .body("//*:AddResult.text()", equalTo("15"))
                        .extract()
                        .xmlPath()
                        .getString("Envelope.Body.AddResponse"); // XPath-like navigation inside the SOAP XML.

        given()
                .body(innerXML)
        .then()
                .body(matchesXsdInClasspath("calculator.xsd"));
    }
}
