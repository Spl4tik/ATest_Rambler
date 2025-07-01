import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {
    private final LoginPage loginPage = new LoginPage();

    @BeforeAll
    public static void setup() {
        Configuration.browser = "chrome"; // или "firefox"
        Configuration.headless = false;   // false для видимого браузера
        Configuration.timeout = 10000;    // 10 секунд
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver(); // Закрыть браузер после каждого теста
    }

    @Test
    @DisplayName("Негативный кейс - Вход с неверными данными")
    public void testNegativeLoginWithInvalidCredentials() {
        loginPage.openLoginPage("https://id.rambler.ru/login-20/login");
        loginPage.login("wrong_username@rambler.ru", "wrong_password");
        assertEquals("Неверная почта или пароль", loginPage.getErrorMessage());
    }

    /*@Test
    @DisplayName("Вход с пустым логином и паролем")
    public void testLoginWithEmptyFields() {
        loginPage.openLoginPage("https://id.rambler.ru/login-20/login");
        loginPage.login("", "");
        assertEquals("Username and password are required", loginPage.getErrorMessage());
    }

    @Test
    @DisplayName("Вход с пустым паролем")
    public void testLoginWithEmptyFields() {
        loginPage.openLoginPage("https://id.rambler.ru/login-20/login");
        loginPage.login("username", "");
        assertEquals("Username and password are required", loginPage.getErrorMessage());
    }

    @Test
    @DisplayName("Вход с пустым логином")
    public void testLoginWithEmptyFields() {
        loginPage.openLoginPage("https://id.rambler.ru/login-20/login");
        loginPage.login("", "password");
        assertEquals("Username and password are required", loginPage.getErrorMessage());
    }*/



}
