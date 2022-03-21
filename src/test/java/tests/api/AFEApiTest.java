package tests.api;

import baseEntities.BaseApiTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static constant.EndPoints.*;
import static io.restassured.RestAssured.given;

public class AFEApiTest extends BaseApiTest {
    int id = 8;
    @Test
    public void getUserByInvalidId(){
        given()
                .pathParam("id",id)
                .when()
                .get(GET_USER)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);

    }

    @Test
    public void getDressByInvalidId(){
        given()
                .pathParam("id",id)
                .when()
                .get(GET_DRESS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);

    }
}
