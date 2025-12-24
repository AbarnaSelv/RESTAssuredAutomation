package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

public class GetAndPostExamples {
	

    @Test
    public void testGet() {
        baseURI = "https://jsonplaceholder.typicode.com";
        
        given()
        .when()
            .get("/users")
        .then()
            .statusCode(200)
            .body("[0].name", equalTo("Leanne Graham"))  // checking first user's name
            .log().all();
    }

    @Test
    public void testPost() {
        //Map<String, Object> map = new HashMap<>();
        JSONObject request = new JSONObject();
        
        request.put("name", "Absharu");
        request.put("job", "Teacher");
        
        System.out.println(request.toJSONString());
        
        baseURI = "https://jsonplaceholder.typicode.com";
        
        given()
            .header("Content-Type", "application/json") // telling backend : I am sending data in JSON format.
            .contentType(ContentType.JSON) // contentType → you SEND JSON
            .accept(ContentType.JSON) // accept → you EXPECT JSON in return
            .body(request.toJSONString())
        .when()
            .post("/posts")
        .then()
            .statusCode(201)
            .log().all();
    }
}
