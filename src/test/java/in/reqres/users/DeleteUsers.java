package in.reqres.users;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by Mitul
 */
public class DeleteUsers extends TestBase {

    @Test
    public void deleteUserById() {
        Response response = given()
                .when()
                .delete("/users/2");
        response.then().statusCode(204);
    }
}
