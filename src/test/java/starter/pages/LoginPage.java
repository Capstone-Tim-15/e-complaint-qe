package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    private By usernameField() {
        return By.id("username");
    }

    private By passwordField() {
        return By.id("password");
    }

    private By loginButton() {
        return By.xpath("/html/body/div/section/div/div/form/button");
    }

    private By forgetPassword() {
        return By.xpath("/html/body/div/section/div/div/p/button/span");
    }

    private By errorMessage() {
        return By.xpath("/html/body/div/div/div/div/div[1]/div[2]");
    }

//    private By incorrectUsnPswdErrMssg() {
//        return By.xpath("//*[@id="17"]");
//    }
//
//    private By missingUsnPswdErrMssg() {
//        return By.xpath("/html/body/div/div/div/div/div[1]");
//    }

    @Step
    public boolean validateOnLoginPage() {
        return $(loginButton()).isDisplayed();
    }

    @Step
    public void inputUsername(String username) {
        $(usernameField()).type(username);
    }

    @Step
    public void inputPassword(String password) {
        $(passwordField()).type(password);
    }

    @Step
    public void clickLoginButton() {
        $(loginButton()).click();
    }

//    @Step
//    public boolean validateLoginButtonDisabled() {
//        return $(loginButton()).isDisabled();
//    }

    @Step
    public boolean validateLoginErrorMessageIsDisplayed() {
        return $((errorMessage())).isDisplayed();
    }

    @Step
    public boolean validateLoginEqualErrorMessage(String message) {
        return $(errorMessage()).getText().equalsIgnoreCase(message);
    }




}
