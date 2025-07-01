import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {
    private final LoginPage loginPage = new LoginPage();

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Негативный кейс - Вход с неверным именем почты и паролем")
    public void testNegativeLoginWithInvalidCredentials() {
        loginPage.openLoginPage("https://id.rambler.ru/login-20/login");
        loginPage.login("wrong_username@rambler.ru", "wrong_password");
        assertEquals("Неверная почта или пароль", loginPage.getErrorMessage());
    }

    @Test
    @DisplayName("Негативный кейс - Вход с пустым именем почты и паролем")
    public void testNegativeLoginWithEpmtyCredentials() {
        loginPage.openLoginPage("https://id.rambler.ru/login-20/login");
        loginPage.login("", "");
        assertEquals("Введите имя почты", loginPage.getUsernameEmailError());
        assertEquals("Введите пароль", loginPage.getPasswordError());
    }

}
