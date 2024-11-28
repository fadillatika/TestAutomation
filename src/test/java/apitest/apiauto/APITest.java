package apitest.apiauto;

import apitest.request.Request;
import apitest.utilities.UtilitiesTest;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class APITest {

    @Before
    public void setup() {
        UtilitiesTest.baseURI();
    }

    @Test
    public void getUserTest(){
        Response response = Request.getRequest(1, 12);
        response.then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().body("page", Matchers.equalTo(1))
                .assertThat().body("per_page", Matchers.equalTo(12))
                .assertThat().body("data[0].id", Matchers.equalTo(1));
    }

    @Test
    public void postUserTest(){
        String name = "vrezach";
        String job = "student";

        Response response = Request.postRequest(name, job);
        response.then().log().all()
                .assertThat().statusCode(201)
                .assertThat().body("name", Matchers.equalTo(name))
                .assertThat().body("job", Matchers.equalTo(job))
                .assertThat().body("$", Matchers.hasKey("id"))
                .assertThat().body("$", Matchers.hasKey("createdAt"));
    }

    @Test
    public void putUserTest(){

        int userId = 5;
        String newName= "User123";

        Response response = Request.putRequest(userId, newName);
        response.then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("first_name", Matchers.equalTo(newName));
    }
}
