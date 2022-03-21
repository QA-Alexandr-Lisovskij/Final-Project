package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class HomeBar {
    private final SelenideElement addToCartSuccessPopup = $(By.className("icon-ok"));
    private final SelenideElement logOutLink = $(By.className("logout"));
    private final SelenideElement accountLink = $(By.className("account"));
    private final SelenideElement searchInput = $(By.id("search_query_top"));
    private final SelenideElement searchButton = $x("//*[@name='submit_search']");
    private final SelenideElement proceedToCheckoutButton = $x("//*[@title='Proceed to checkout']");


    public void searchItem(String string){
        searchInput.sendKeys(string);
        searchButton.click();
    }

    public String getValueBySearchField(){
        return searchInput.getValue();
    }

    public void logoutLinkClick(){
        logOutLink.click();
    }

    public void checkoutButtonClick(){
        proceedToCheckoutButton.click();
    }

    public boolean successPopupIsDisplayed(){
        return addToCartSuccessPopup.isDisplayed();
    }
    public boolean accountLinkIsDisplayed(){
        return accountLink.isDisplayed();
    }
}
