package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static constant.EndPoints.CART_PAGE;

public class CartPage extends HomeBar {
    private final SelenideElement deleteItemButton = $(By.className("icon-trash"));
    private final SelenideElement cartIsEmptyAlert = $x("//*[.='Your shopping cart is empty.']");

    public CartPage() {
        open(CART_PAGE);
    }

    public void deleteItem(){
        deleteItemButton.scrollTo().click();
    }

    public boolean alertIsDisplayed(){
       return cartIsEmptyAlert.isDisplayed();
    }
}
