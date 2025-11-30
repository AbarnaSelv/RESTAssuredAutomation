package tests;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class PutPatchDeleteExamples {

    // PUT request → used to UPDATE the full resource
    @Test
    public void testPut() {

        JSONObject request = new JSONObject();
        request.put("name", "Abarna");
        request.put("job", "QA Engineer");

        System.out.println(request.toJSONString());

        baseURI = "https://jsonplaceholder.typicode.com";

        given()
            .header("Content-Type", "application/json")
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(request.toJSONString())
        .when()
            .put("/posts/1") // PUT means full update of post with ID 1 like..  /users/{id}
        .then()
            .statusCode(200)
            .log().all();
    }

    // PATCH request → used to UPDATE only a part of the resource
    @Test
    public void testPatch() {

        JSONObject request = new JSONObject();
        request.put("job", "Senior QA Engineer"); // only job is updated

        System.out.println(request.toJSONString());

        baseURI = "https://jsonplaceholder.typicode.com";

        given()
            .header("Content-Type", "application/json")
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(request.toJSONString())
        .when()
            .patch("/posts/1") // PATCH means partial update
        .then()
            .statusCode(200)
            .log().all();
    }

    // DELETE request → used to remove a resource
    @Test
    public void testDelete() {

        baseURI = "https://jsonplaceholder.typicode.com";

        when()
            .delete("/posts/1") // delete the post with ID 1
        .then()
            .statusCode(200)
            .log().all();
    }
}
