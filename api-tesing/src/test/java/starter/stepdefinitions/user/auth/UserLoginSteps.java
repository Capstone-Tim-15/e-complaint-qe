package starter.stepdefinitions.user.auth;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;
import starter.gocat.user.auth.UserLogin;

public class UserLoginSteps {
    @Steps
    UserLogin userLogin;

    @Given("I set {string} endpoint for user login")
    public void setEndpointUserLogin(String endpointType) {
        userLogin.setEndpointUserLogin(endpointType);
    }

    @When("I send post request with valid requestBody to {string} user login endpoint")
    public void sendPostInvalidUserLoginEndpoint(String baseType) {
        userLogin.sendPostInvalidUserLoginEndpoint(baseType);
    }

    @When("I send post request with {string} to valid user login endpoint")
    public void sendPostValidUserLoginEndpoint(String credentialType) {
        userLogin.sendPostValidUserLoginEndpoint(credentialType);
    }

    @When("I send {string} request to user login")
    public void sendOtherMethodToUserLogin(String methodType) {
        userLogin.sendOtherMethodToUserLogin(methodType);
    }

    @And("I receive my token account")
    public void receiveTokenAccount() {
        userLogin.receiveTokenAccount();
    }
    }

