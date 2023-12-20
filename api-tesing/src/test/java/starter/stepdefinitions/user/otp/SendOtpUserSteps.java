package starter.stepdefinitions.user.otp;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.gocat.user.otp.SendOtpUser;

public class SendOtpUserSteps {
    @Steps
    SendOtpUser sendOtpUser;

    @Given("I set {string} endpoint for send otp user")
    public void setEndpointSendOtpUser(String endpointType) {
        sendOtpUser.setEndpointSendOtpUser(endpointType);
    }

    @When("I send post request to {string} send otp user endpoint")
    public void sendGetBaseTypeSendOtpUserEndpoint(String baseType) {
        sendOtpUser.sendGetBaseTypeSendOtpUserEndpoint(baseType);
    }

    @And("I receive otp user")
    public void receiveOtpUser() {
        sendOtpUser.receiveOtpUser();
    }
}
