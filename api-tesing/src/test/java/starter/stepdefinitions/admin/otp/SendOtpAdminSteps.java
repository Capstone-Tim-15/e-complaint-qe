package starter.stepdefinitions.admin.otp;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.gocat.admin.otp.SendOtpAdmin;

public class SendOtpAdminSteps {
    @Steps
    SendOtpAdmin sendOtpAdmin;

    @Given("I set {string} endpoint for send otp admin")
    public void setEndpointSendOtpAdmin(String endpointType) {
        sendOtpAdmin.setEndpointSendOtpAdmin(endpointType);
    }

    @When("I send post request to {string} send otp admin endpoint")
    public void sendGetBaseTypeSendOtpAdminEndpoint(String baseType) {
        sendOtpAdmin.sendPostBaseTypeSendOtpAdminEndpoint(baseType);
    }

    @And("I receive otp admin")
    public void receiveOtpAdmin() {
        sendOtpAdmin.receiveOtpAdmin();
    }
}
