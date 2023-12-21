package starter.stepdefinitions.admin.auth;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.gocat.admin.auth.RegisterAdmin;

public class RegisterAdminSteps {
    @Steps
    RegisterAdmin adminRegister;

    @Given("I set {string} endpoint for admin register")
    public void setEndpointAdminRegister(String endpointType) {
        adminRegister.setEndpointAdminRegister(endpointType);
    }

    @When("I send post request with {string} to valid admin register endpoint")
    public void sendPostValidAdminRegisterEndpoint(String credentialType) {
        adminRegister.sendPostValidAdminRegisterEndpoint(credentialType);
    }

    @When("I send post request with valid requestBody to {string} admin register endpoint")
    public void sendPostInvalidAdminRegisterEndpoint(String baseType) {
        adminRegister.sendPostInvalidAdminRegisterEndpoint(baseType);
    }

    @When("I send {string} request to admin register")
    public void sendOtherMethodToAdminRegister(String methodType) {
        adminRegister.sendOtherMethodToAdminRegister(methodType);
    }

    @And("I receive my detail account")
    public void receiveTokenAccount() {
        adminRegister.receiveDetailAccount();
    }

}
