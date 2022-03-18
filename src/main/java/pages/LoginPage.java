package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import dbEntries.UsersTable;
import model.User;
import org.openqa.selenium.By;


import java.sql.ResultSet;
import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static constant.EndPointsUrl.LOGIN_PAGE;

public class LoginPage extends HomeBar {
	private final SelenideElement emailField = $(By.id("email"));
	private final SelenideElement passwordField = $(By.id("passwd"));
	private final SelenideElement signInButton = $(By.id("SubmitLogin"));
	private final SelenideElement alertBarDanger = $(By.className("alert-danger"));


	public LoginPage() {
		open(LOGIN_PAGE);
	}

	public User getUser() {
		setUpConnectionDB();
		UsersTable usersTable = new UsersTable(dataBaseService);
		ResultSet resultSet = usersTable.getUserByID(1);

		try {
			while (resultSet.next()) {
				return User.builder()
						.login(resultSet.getString("login"))
						.password(resultSet.getString("password"))
						.build();

			}
		} catch (SQLException e) {
			logger.error(e.toString());
		}
		closeConnectionDB();
		return null;
	}

	public void LoginWithCredentials(String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		signInButton.click();
	}

	public void LoginWithUser(User user) {
		emailField.sendKeys(user.getLogin());
		passwordField.sendKeys(user.getPassword());
		signInButton.click();
	}


}
