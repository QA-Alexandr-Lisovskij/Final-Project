package pages;

import com.codeborne.selenide.SelenideElement;
import model.ItemDress;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static constant.EndPoints.ITEM_PAGE;

public class ItemPage extends HomeBar {

    private final SelenideElement sizeOptionDropdown = $(By.id("group_1"));
    private final SelenideElement addToCartButton = $x("//*[.='Add to cart']");
    private final SelenideElement openIdent = $x("//h1[@itemprop='name']");

    public ItemPage(String optionWithUrl) {
        open(ITEM_PAGE);
    }

    public ItemPage() {
    }

    public boolean itemPageIsOpen(){
        return openIdent.isDisplayed();
    }

    public String getValueBySizeOption(){
        return sizeOptionDropdown.getText();
    }

    public void chooseSizeDress(String size){
        switch (size) {
            case "S":
                sizeOptionDropdown.scrollTo().selectOption(0);
                break;
            case "M":
                sizeOptionDropdown.scrollTo().selectOption(1);
                break;
            case "L":
                sizeOptionDropdown.scrollTo().selectOption(2);
                break;
            default:
                System.out.println("No dress size found!");
                break;
        }

    }

    public void chooseColorDress(String color){
        $(By.name(color)).scrollTo().click();
    }

    public void clickToAddButton(){
        addToCartButton.scrollTo().click();
    }

    public void addToCart(ItemDress itemDress){
        chooseSizeDress(itemDress.getSize());
        chooseColorDress(itemDress.getColor());
        clickToAddButton();
        successPopupIsDisplayed();
    }





}
