package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import model.User;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Randomization;


import static constant.EndPoints.*;
import static io.restassured.RestAssured.given;

public class NFEApiTest extends BaseApiTest {



    @Test
    public void getUserById() {
        int userID = 1;
        Gson gson = new Gson();

        User expectedUser = User.builder()
                .id(1)
                .login("lisovskij.sanya@mail.ru")
                .password("3626831Cfyz@")
                .build();

        Response response = given()
                .pathParam("id",userID)
                .get(GET_USER);
        User actualUser = gson.fromJson(response.getBody().asString(), User.class);
        Assert.assertEquals(actualUser, expectedUser);

    }

    @Test
    public void addUser() {
        User user = User.builder()
                .login(Randomization.randomString(5))
                .password(Randomization.randomString(5))
                .build();

        given()
                .body(user, ObjectMapperType.GSON)
                .when()
                .post(ADD_USER)
                .then().log().body()
                .statusCode(HttpStatus.SC_CREATED);
    }
}
