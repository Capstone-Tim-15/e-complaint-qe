package starter.stepdefinitions.admin.auth;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.gocat.admin.auth.ResetPasswordAdmin;

public class ResetPasswordAdminSteps {
    @Steps
    ResetPasswordAdmin resetPasswordAdmin;

    @Given("I set valid endpoint for reset password admin")
    public void setEndpointResetPasswordAdmin() {
        resetPasswordAdmin.setEndpointResetPasswordAdmin();
    }

    @When("I send post request with {string} to valid reset password admin endpoint")
    public void sendPostValidResetPasswordAdminEndpoint(String credentialType) {
        resetPasswordAdmin.sendPostValidResetPasswordAdminEndpoint(credentialType);
    }

    @When("I send post request to valid reset password admin endpoint without login")
    public void sendPostToResetPasswordAdminWithoutLogin() {
        resetPasswordAdmin.sendPostToResetPasswordAdminWithoutLogin();
    }
}
