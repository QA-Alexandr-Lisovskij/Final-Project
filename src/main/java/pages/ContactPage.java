package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static constant.EndPointsUrl.CONTACT_PAGE;

public class ContactPage extends HomeBar {

    private final SelenideElement subjectHeadingDropDown = $(By.id("id_contact"));
    private final SelenideElement orderReferenceDropDown = $(By.name("id_order"));
    private final SelenideElement messageField = $(By.id("message"));
    private final SelenideElement productDropDown = $(By.name("id_product"));
    private final SelenideElement inputForLoadFile = $(By.name("fileUpload"));
    private final SelenideElement sendButton = $(By.id("submitMessage"));
    private final SelenideElement successAlert = $x("//p[.='Your message has been successfully sent to our team.']");


    public ContactPage() {
        open(CONTACT_PAGE);
    }

    public void sendMail() {
        subjectHeadingDropDown.selectOption(1);
        orderReferenceDropDown.selectOption(1);
        productDropDown.scrollTo().selectOption(1);
        inputForLoadFile.setValue("D:/ot_gvozd_do_sandala.pdf");
        messageField.sendKeys("My message");
        sendButton.scrollTo().click();
    }

    public boolean successAlertIsVisible(){
        return successAlert.isDisplayed();
    }
}
