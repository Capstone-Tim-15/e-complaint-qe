package org.example.steps.auth;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.BaseTest;
import org.junit.jupiter.api.Assertions;

public class RegisterSteps extends BaseTest {


    @Given("I am on register page")
    public void onRegisterPage() {

        Assertions.assertTrue(govComplaintPage.intro1());
        govComplaintPage.swipe1();

        Assertions.assertTrue(govComplaintPage.intro2());
        govComplaintPage.swipe2();

        Assertions.assertTrue(govComplaintPage.intro3());
        govComplaintPage.clickNextButton();

        Assertions.assertTrue(registerPage.validateOnRegisterPage());
    }

    @When("I input valid credentials")
    public void inputRegistValidCredentials() {
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String username = faker.name().firstName();
        String email = faker.internet().safeEmailAddress();

        registerPage.inputName(name);
        registerPage.inputPhone("0812345678");
        registerPage.inputEmail(email);
        registerPage.inputUsername(username);
        registerPage.inputPassword("12345678");
        registerPage.inputConfirmPassword("12345678");
    }

    @And("I click register button")
    public void clickRegistButton() {
        registerPage.clickRegisterButton();
    }

    @Then("I redirect to sign in page")
    public void redirectSignInPage() {
        Assertions.assertTrue(Boolean.parseBoolean(signInPage.getSignInButton()));
    }
}
