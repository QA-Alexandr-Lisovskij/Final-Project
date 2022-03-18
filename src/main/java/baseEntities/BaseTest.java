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

public class BaseTest {

    public User validUser;
    public User invalidUser;
    public ItemDress validDress;


    @BeforeMethod
    public void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(false));

        DriverService.initDriver();
        ApiService.initApi();
        validUser = ApiService.getValidUser();
        invalidUser = ApiService.getInvalidUser();
        validDress = ApiService.getDress();
        LoginPage loginPage = new LoginPage();
        loginPage.LoginWithUser(validUser);
    }


    @AfterMethod
    public void tearDown() {
        DriverService.close();
    }


    @DataProvider(name = "data-provider")
    public Object[][] dpMethod (Method m){
        switch (m.getName()) {
            case "limitValueTest":
                return new Object[][] {{Randomization.randomString(1),1}, {Randomization.randomString(30),30}};
            case "dataOverageTest":
                return new Object[][] {{Randomization.randomString(31),30}};
        }
        return null;

    }
}
