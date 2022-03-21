package baseEntities;


import com.codeborne.selenide.logevents.SelenideLogger;
import core.ApiService;
import core.DriverService;
import io.qameta.allure.selenide.AllureSelenide;
import model.ItemDress;
import model.User;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.Randomization;

import java.lang.reflect.Method;

import static core.DriverService.maximize;
import static core.DriverService.waitForUrlContains;


public class BaseTest {

    public User validUser;
    public User invalidUser;
    public ItemDress validDress;

    @BeforeClass
    public void setUpConfig(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true));
        DriverService.initDriver();
        ApiService.initApi();
        validUser = ApiService.getValidUser();
        invalidUser = ApiService.getInvalidUser();
        validDress = ApiService.getDress();
    }
    @BeforeMethod
    public void loginUser() throws InterruptedException {
        LoginPage loginPage;
        do{
            loginPage = new LoginPage();
            if(waitForUrlContains("account")){

            }else {
                wait(15);
            }
        }while (!loginPage.emailFieldIsVisible());
        maximize();
        loginPage.LoginWithUser(validUser);
    }


    @AfterMethod
    public void tearDown() {
        DriverService.close();
    }
    @AfterClass
    public void driverDown(){
        DriverService.close();
    }


    @DataProvider(name = "data-provider")
    public Object[][] dpMethod (Method m){
        switch (m.getName()) {
            case "limitValueTest":
                return new Object[][] {{Randomization.randomString(1),1}, {Randomization.randomString(30),30}};
            case "dataOverageTest":
                return new Object[][] {{Randomization.randomString(31),30}};
            case "getUserByInvalidId":
            case "getDressByInvalidId":
                return new Object[][] {{4}};
            case "getUserById":
                return new Object[][] {{1}};
        }
        return null;

    }
}
