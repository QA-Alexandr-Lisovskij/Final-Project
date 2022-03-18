package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import core.DriverService;
import dbEntries.DressesTable;
import model.ItemDress;
import org.openqa.selenium.By;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static constant.EndPointsUrl.DRESSES_PAGE;

public class DressesCatalogPage extends HomeBar {

    private final SelenideElement casualDressesOption = $(By.id("layered_category_9"));
    private final SelenideElement eveningDressesOption = $(By.id("uniform-layered_category_10"));
    private final SelenideElement summerDressesOption = $(By.id("layered_category_11"));
    private final SelenideElement sizeSOption = $(By.id("layered_id_attribute_group_1"));
    private final SelenideElement sizeMOption = $(By.id("layered_id_attribute_group_2"));
    private final SelenideElement sizeLOption = $(By.id("layered_id_attribute_group_3"));
    private final SelenideElement colorWhiteOption = $(By.id("layered_id_attribute_group_8"));
    private final SelenideElement colorOrangeOption = $(By.id("layered_id_attribute_group_13"));
    private final SelenideElement colorGreenOption = $(By.id("layered_id_attribute_group_15"));
    private final SelenideElement colorBlackOption = $(By.id("layered_id_attribute_group_11"));
    private final SelenideElement colorBlueOption = $(By.id("layered_id_attribute_group_14"));
    private final SelenideElement colorYellowOption = $(By.id("layered_id_attribute_group_16"));
    private final SelenideElement itemImage = $x("//*[@itemprop='image']");
    private final SelenideElement itemMoreButton = $x("//*[.='More']");
    private final SelenideElement itemForm = $x("//h1[@itemprop='name']");
    private final SelenideElement addToCardSuccessPopup = $(By.className("icon-ok"));



    public DressesCatalogPage() {
        open(DRESSES_PAGE);
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

    public void checkDressType(String type){
        switch (type) {
            case "summer dress":
                summerDressesOption.scrollTo().click();
                break;
            case "casual dress":
                casualDressesOption.scrollTo().click();
                break;
            case "evening dress":
                eveningDressesOption.scrollTo().click();
                break;
            default:
                System.out.println("No dress type found!");
                break;
        }
    }

    public void checkDressSize(String size){
        switch (size) {
            case "S":
                sizeSOption.scrollTo().click();
                break;
            case "M":
                sizeMOption.scrollTo().click();
                break;
            case "L":
                sizeLOption.scrollTo().click();
                break;
            default:
                System.out.println("No dress size found!");
                break;
        }
    }

    public void checkDressColor(String color){
        switch (color) {
            case "White":
                colorWhiteOption.scrollTo().click();
                break;
            case "Orange":
                colorOrangeOption.scrollTo().click();
                break;
            case "Green":
                colorGreenOption.scrollTo().click();
                break;
            case "Black":
                colorBlackOption.scrollTo().click();
                break;
            case "Blue":
                colorBlueOption.scrollTo().click();
                break;
            case "Yellow":
                colorYellowOption.scrollTo().click();
                break;
            default:
                System.out.println("No dress color found!");
                break;
        }
    }

    public void addDressToCard(ItemDress itemDress){
        checkDressType(itemDress.getType());
        checkDressSize(itemDress.getSize());
        checkDressColor(itemDress.getColor());
        DriverService.waitForUrlContains("color");
        itemImage.should(visible).scrollTo().hover();
        itemMoreButton.should(visible).click();
    }

    public void clickForItem(){
        itemImage.scrollTo().click();
    }

    public boolean itemFormIsDisplayed(){
        return itemForm.isDisplayed();
    }




}
