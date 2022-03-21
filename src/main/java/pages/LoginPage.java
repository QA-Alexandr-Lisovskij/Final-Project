package pages;

import com.codeborne.selenide.SelenideElement;
import model.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static constant.EndPoints.LOGIN_PAGE;

public class LoginPage extends HomeBar {
	private final SelenideElement emailField = $(By.id("email"));
	private final SelenideElement passwordField = $(By.id("passwd"));
	private final SelenideElement signInButton = $(By.id("SubmitLogin"));
	private final SelenideElement alertBarDanger = $(By.className("alert-danger"));


	public LoginPage() {
		open(LOGIN_PAGE);
	}

	public boolean emailFieldIsVisible(){
		return emailField.isDisplayed();
	}

	public void LoginWithUser(User user) {
		emailField.sendKeys(user.getLogin());
		passwordField.sendKeys(user.getPassword());
		signInButton.click();
	}


}
