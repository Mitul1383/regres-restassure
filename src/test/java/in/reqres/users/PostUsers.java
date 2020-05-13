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
public class PostUsers extends TestBase {

    String name = "Prem" + getRandomString(5);
    String job = "Manager" + getRandomString(2);
    String email = "Api@reqres.in" + getRandomString(5);
    String password = "Manager@" + getRandomString(2);

    @Test
    public void createNewsUser() {

        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setJob(job);

        Response response = given()
                .header("content-Type", "application/json")
                .when()
                .body(userPojo)
                .post("/users");
        response.then().statusCode(201)
                .log().body();

    }

    @Test
    public void registerUserSuccessfully() {

        UserPojo userPojo = new UserPojo();
        userPojo.setEmail(email = "Api@reqres.in");
        userPojo.setPassword(password);
        Response response = given()
                .header("content-Type", "application/json")
                .when()
                .body(userPojo)
                .post("/register");
        response.then().statusCode(200)
                .log().body();

    }

    @Test
    public void UnsuccessfullyRegistration() {

        UserPojo userPojo = new UserPojo();
        userPojo.setEmail(email = "Api@reqres.in");
        Response response = given()
                .header("content-Type", "application/json")
                .when()
                .body(userPojo)
                .post("/register");
        response.then().statusCode(400)
                .log().body();
    }

    @Test
    public void userShouldLoginSuccessfully() {

        UserPojo userPojo = new UserPojo();
        userPojo.setEmail(email = "Api@reqres.in");
        userPojo.setPassword(password);
        Response response = given()
                .header("content-Type", "application/json")
                .when()
                .body(userPojo)
                .post("/login");
        response.then().statusCode(200)
                .log().body();


    }
}