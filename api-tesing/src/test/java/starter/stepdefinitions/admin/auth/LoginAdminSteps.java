package starter.stepdefinitions.admin.auth;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.gocat.admin.auth.LoginAdmin;

public class LoginAdminSteps {
    @Steps
    LoginAdmin adminLogin;

    @Given("I set {string} endpoint for admin login")
    public void setEndpointAdminLogin(String endpointType) {
        adminLogin.setEndpointAdminLogin(endpointType);
    }

    @When("I send post request with valid requestBody to {string} admin login endpoint")
    public void sendPostToBaseTypeAdminLoginEndpoint(String baseType) {
        adminLogin.sendPostToBaseTypeAdminLoginEndpoint(baseType);
    }

    @When("I send post request with {string} to valid admin login endpoint")
    public void sendPostValidAdminLoginEndpoint(String credentialType) {
        adminLogin.sendPostValidAdminLoginEndpoint(credentialType);
    }

    @When("I send {string} request to admin login")
    public void sendOtherMethodToAdminLogin(String methodType) {
        adminLogin.sendOtherMethodToAdminLogin(methodType);
    }


}
