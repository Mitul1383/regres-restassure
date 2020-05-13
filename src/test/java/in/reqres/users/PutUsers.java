package in.reqres.users;

import in.reqres.UserPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static in.reqres.UserPojo.getRandomString;
import static io.restassured.RestAssured.given;

/**
 * Created by Mitul
 */
public class PutUsers extends TestBase {

    String name = "Prem" + getRandomString(5);
    String job = "Manager" + getRandomString(2);


    @Test
    public void updateUsers() {

        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setJob(job);

        Response response = given()
                .header("content-Type", "application/json")
                .when()
                .body(userPojo)
                .put("/users/8");
        response.then().statusCode(200)
                .log().body();

    }

}
