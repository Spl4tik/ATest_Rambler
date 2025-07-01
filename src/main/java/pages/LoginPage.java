package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    // Локаторы элементов - A
    private final SelenideElement usernameField = $("input#login");
    private final SelenideElement passwordField = $("input#password");
    private final SelenideElement loginButton = $("button[data-cerber-id='login_form::main::login_button']");
    private final SelenideElement errorMessage = $("div.rc__bmhVM");
    private final SelenideElement usernameEmailError = $("section:nth-of-type(1) div.rc__bmhVM");
    private final SelenideElement passwordError = $("section:nth-of-type(2) div.rc__bmhVM");

    // Методы для взаимодействия со страницей
    public void openLoginPage(String url) {
        open(url);
    }

    public void enterUsername(String username) {
        usernameField.setValue(username);
    }

    public void enterPassword(String password) {
        passwordField.setValue(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public String getUsernameEmailError() {
        return usernameEmailError.getText();
    }

    public String getPasswordError() {
        return passwordError.getText();
    }

    // Комбинированный метод для быстрого входа
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}
