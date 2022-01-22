package starter.login;

import org.openqa.selenium.By;

public class LoginPageObjects {
    public static By USERNAME_FIELD = By.id("user-name");
    public static By PASSWORD_FIELD = By.id("password");
    public static By LOGIN_BUTTON = By.id("login-button");
    public static By MESSAGE_ALERT = By.className("error-message-container");

}
