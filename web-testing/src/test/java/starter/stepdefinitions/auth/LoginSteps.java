package starter.stepdefinitions.auth;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Assertions;
import starter.pages.DashboardPage;
import starter.pages.HomePage;
import starter.pages.LoginPage;

public class LoginSteps {

    @Steps
    HomePage homePage;

    @Steps
    LoginPage loginPage;

    @Steps
    DashboardPage dashboardPage;

    @Given("I am on home page")
    public void onHomePage() {
        homePage.openUrl("https://gov-complaint-fe.vercel.app/");
        Assertions.assertTrue(homePage.validateOnHomePage());
    }

    @When("I click login menu")
    public void clickLoginMenU() {
        homePage.clickLoginMenu();
    }

    @And("I redirect to login page")
    public void redirectLoginPage() {
        loginPage.validateOnLoginPage();
    }

    @And("I input valid username for login")
    public void inputValidUsername() {
        loginPage.inputUsername("anggun");
    }

    @And("I input invalid username for login")
    public void inputInvalidUsername() {
        loginPage.inputUsername("invalid");
    }

    @And("I empty username for login")
    public void emptyUsername() {
        loginPage.inputUsername("");
    }

    @And("I input valid password for login")
    public void inputValidPassword() {
        loginPage.inputPassword("1234567890");
    }

    @And("I input invalid password for login")
    public void inputInvalidPassword() {
        loginPage.inputPassword("invalid");
    }

    @And("I empty password for login")
    public void emptyPassword() {
        loginPage.inputPassword("");
    }

    @And("I click login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I am on dashboard page")
    public void onDashboardPage() {
        Assertions.assertTrue(dashboardPage.validateOnDashboard());
    }

    @Then("I receive error message {string}")
    public void receiveErrorMessage(String message) {
        Assertions.assertTrue(loginPage.validateLoginErrorMessageIsDisplayed());
        Assertions.assertTrue(loginPage.validateLoginEqualErrorMessage(message));
    }
}
