package apitest.request;

import apitest.utilities.UtilitiesTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class Request {

    public static Response getRequest(int userId, int perpage) {
        UtilitiesTest perpages = new UtilitiesTest();
        int result = perpages.getUser(perpage);
        return given()
                .contentType(ContentType.JSON)
                .queryParam("page", userId)
                .queryParam("per_page", result)
                .when()
                .get("api/users/");
    }

    public static Response postRequest(String name, String job) {
        JSONObject jsonObject = UtilitiesTest.userData(name, job);
        return given()
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .when()
                .post("api/users/");
    }

    public static Response putRequest(int userId, String newName) {
        JSONObject jsonObject = UtilitiesTest.putData(userId, newName);
        return given()
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .when()
                .put("api/users/" + userId);
    }

}
