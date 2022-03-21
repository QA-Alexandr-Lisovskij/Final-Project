package tests.gui;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class PositiveTest extends BaseTest {

    @Test
    public void entityAdditionTest(){
        DressesCatalogPage dressesCatalogPage = new DressesCatalogPage();
        dressesCatalogPage.addDressToCard(validDress);
        ItemPage itemPage = new ItemPage();
        Assert.assertTrue(itemPage.itemPageIsOpen());
        itemPage.addToCart(validDress);
        itemPage.checkoutButtonClick();
        CartPage cartPage = new CartPage();
        Assert.assertTrue(!cartPage.alertIsDisplayed());
    }

    @Test
    public void entityDeletingTest(){
        DressesCatalogPage dressesCatalogPage = new DressesCatalogPage();
        dressesCatalogPage.addDressToCard(validDress);
        ItemPage itemPage = new ItemPage();
        Assert.assertTrue(itemPage.itemPageIsOpen());
        itemPage.addToCart(validDress);
        itemPage.checkoutButtonClick();
        CartPage cartPage = new CartPage();
        cartPage.deleteItem();
       // Assert.assertTrue(!cartPage.itemIsDisplayed());
    }

    @Test
    public void uploadFileTest(){
        ContactPage contactPage = new ContactPage();
        contactPage.sendMail();
        contactPage.successAlertIsVisible();
    }

    @Test
    public void dialogBoxTest() {
        DressesCatalogPage dressesCatalogPage = new DressesCatalogPage();
        dressesCatalogPage.clickForItem();
        dressesCatalogPage.itemFormIsDisplayed();
    }

    @Test
    public void popUpTest(){
        ItemPage itemPage = new ItemPage("url");
        itemPage.clickToAddButton();
        itemPage.successPopupIsDisplayed();
    }

    @Test(dataProvider = "data-provider", dataProviderClass = BaseTest.class)
    public void limitValueTest(String searchString,int expectedDataSize){
        String actualDataSize;
        HomeBar homeBar = new HomeBar();
        homeBar.searchItem(searchString);
        actualDataSize = homeBar.getValueBySearchField();
        Assert.assertEquals(actualDataSize.length(),expectedDataSize);

    }


}
