package core;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.ItemDress;
import model.User;
import org.apache.http.protocol.HTTP;

import static constant.EndPointsApi.*;
import static constant.Urls.API_URL;
import static io.restassured.RestAssured.given;

public class ApiService {
    private static final int vID = 1;
    private static final int invID = 2;
    private static final Gson gson = new Gson();

    public static void initApi(){
        RestAssured.baseURI = API_URL;
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
    }

    public static User getValidUser(){
        User user;
        Response response = given()
                .pathParam("id",vID)
                .get(GET_USER);
        return user = gson.fromJson(response.getBody().asString(), User.class);
    }
    public static User getInvalidUser(){
        User user;
        Response response = given()
                .pathParam("id",invID)
                .get(GET_USER);
        return user = gson.fromJson(response.getBody().asString(), User.class);
    }

    public static ItemDress getDress(){
        ItemDress dress;
        Response response = given()
                .pathParam("id",vID)
                .get(GET_DRESS);
        return dress = gson.fromJson(response.getBody().asString(), ItemDress.class);
    }




}
