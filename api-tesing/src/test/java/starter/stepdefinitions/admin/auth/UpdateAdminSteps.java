package starter.stepdefinitions.admin.auth;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.gocat.admin.auth.UpdateAdmin;

public class UpdateAdminSteps {
    @Steps
    UpdateAdmin updateAdmin;

    @Given("I set {string} endpoint for update admin")
    public void setEndpointUpdateAdmin(String endpointType) {
        updateAdmin.setEndpointUpdateAdmin(endpointType);
    }

    @When("I send put request with {string} to valid update admin endpoint")
    public void sendPostValidUpdateAdminEndpoint(String credentialType) {
        updateAdmin.sendPostValidUpdateAdminEndpoint(credentialType);
    }

    @When("I send put request with valid requestBody to {string} update admin endpoint")
    public void sendPostBaseTypeUpdateAdminEndpoint(String baseType) {
        updateAdmin.sendPostBaseTypeUpdateAdminEndpoint(baseType);
    }

    @When("I send {string} request to update admin")
    public void sendOtherMethodToUpdateAdmin(String methodType) {
        updateAdmin.sendOtherMethodToUpdateAdmin(methodType);
    }
}
