package apitest.utilities;

import io.restassured.RestAssured;
import org.json.JSONObject;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UtilitiesTest {

    public static void baseURI () {
        RestAssured.baseURI = "https://reqres.in/";
    }

    public static JSONObject userData (String name, String job) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("job", job);
        return jsonObject;
    }

    public static JSONObject putData (int userId, String newName) {
        String lname = given().when().get("api/users/" + userId).getBody().jsonPath().get("data.last_name");
        String avatar = given().when().get("api/users/" + userId).getBody().jsonPath().get("data.avatar");
        String email = given().when().get("api/users/" + userId).getBody().jsonPath().get("data.email");
        HashMap<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("id", userId);
        bodyMap.put("email", email);
        bodyMap.put("first_name", newName);
        bodyMap.put("last_name", lname);
        bodyMap.put("avatar", avatar);
        JSONObject jsonObject;
        jsonObject = new JSONObject (bodyMap);
        return jsonObject;
    }

    public int getUser (int perpage){
        if (perpage >=2 && perpage <= 12){
            return perpage;
        } else {
            return 2;
        }
    }

}
