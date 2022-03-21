package tests.gui;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DressesCatalogPage;
import pages.HomeBar;
import pages.ItemPage;
import pages.LoginPage;

public class NegativeTest extends BaseTest {


    @Test(dataProvider = "data-provider", dataProviderClass = BaseTest.class)
    public void dataOverageTest(String searchString,int expectedDataSize){
        String actualDataSize;
        HomeBar homeBar = new HomeBar();
        homeBar.searchItem(searchString);
        actualDataSize = homeBar.getValueBySearchField();
        Assert.assertEquals(actualDataSize.length(),expectedDataSize,"Поле поиска принимает большее количество символов чем необходимо в требованиях.");

    }

    @Test
    public void invalidDataTest(){
        HomeBar homeBar = new HomeBar();
        homeBar.logoutLinkClick();
        LoginPage loginPage = new LoginPage();
        loginPage.LoginWithUser(invalidUser);
        Assert.assertTrue(homeBar.accountLinkIsDisplayed(),"Данные пользователя не валидны.");
    }

    @Test
    public void entityAdditionBugTest(){
        DressesCatalogPage dressesCatalogPage = new DressesCatalogPage();
        dressesCatalogPage.addDressToCard(validDress);
        ItemPage itemPage = new ItemPage();
        Assert.assertEquals(itemPage.getValueBySizeOption(),validDress.getSize(),"Актуальный параметр обьекта не соответствует ожидаемому.");
    }
}
