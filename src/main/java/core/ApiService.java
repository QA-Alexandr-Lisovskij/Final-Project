package core;

import com.google.gson.Gson;
import dbEntries.DressesTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.ItemDress;
import model.User;
import org.apache.http.protocol.HTTP;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

import static constant.EndPoints.*;
import static constant.Urls.API_URL;
import static io.restassured.RestAssured.given;

public class ApiService {
    private static final int vID = 1;
    private static final int invID = 2;
    private static final Gson gson = new Gson();
    private static User user;
    private static ItemDress dress;
    protected DataBaseService dataBaseService;
    public static Logger logger = Logger.getLogger(ApiService.class);

    public void setUpConnectionDB() {
        dataBaseService = new DataBaseService();
    }

    public void closeConnectionDB(){
        dataBaseService.closeConnection();
    }


    public static void initApi(){
        RestAssured.baseURI = API_URL;
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
    }

    public static User getValidUser(){
        Response response = given()
                .pathParam("id",vID)
                .get(GET_USER);
        return user = gson.fromJson(response.getBody().asString(), User.class);
    }
    public static User getInvalidUser(){
        Response response = given()
                .pathParam("id",invID)
                .get(GET_USER);
        return user = gson.fromJson(response.getBody().asString(), User.class);
    }

    public static ItemDress getDress(){
        Response response = given()
                .pathParam("id",vID)
                .get(GET_DRESS);
        return dress = gson.fromJson(response.getBody().asString(), ItemDress.class);
    }

    public ItemDress getItemDress() {
        setUpConnectionDB();
        DressesTable dressesTable = new DressesTable(dataBaseService);
        ResultSet resultSet = dressesTable.getDressByID(1);

        try {
            while (resultSet.next()) {
                return ItemDress.builder()
                        .type(resultSet.getString("type"))
                        .size(resultSet.getString("size"))
                        .color(resultSet.getString("color"))
                        .build();

            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        closeConnectionDB();
        return null;
    }



}
