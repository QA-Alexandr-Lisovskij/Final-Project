package tests.api;

import baseEntities.BaseApiTest;
import baseEntities.BaseTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static constant.EndPoints.*;
import static io.restassured.RestAssured.given;

public class AFEApiTest extends BaseApiTest {

    @Test(dataProvider = "data-provider", dataProviderClass = BaseTest.class)
    public void getUserByInvalidId(int id){
        given()
                .pathParam("id",id)
                .when()
                .get(GET_USER)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);

    }

    @Test(dataProvider = "data-provider", dataProviderClass = BaseTest.class)
    public void getDressByInvalidId(int id){
        given()
                .pathParam("id",id)
                .when()
                .get(GET_DRESS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);

    }
}
