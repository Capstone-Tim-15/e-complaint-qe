package starter.stepdefinitions.user.complaint;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.gocat.user.complaint.CreateComplaint;

public class CreateComplaintSteps {
    @Steps
    CreateComplaint createComplaint;

    @Given("I set {string} endpoint for create complaint")
    public void setEndpointCreateComplaint (String endpointType){
        createComplaint.setEndpointCreateComplaint(endpointType);
    }

    @When("I send post request with {string} to valid create complaint endpoint")
    public void sendPostValidUserLoginEndpoint(String credentialType) {
        createComplaint.sendPostValidCreateComplaintEndpoint(credentialType);
    }

    @When("I send post request with valid requestBody to invalid create complaint endpoint")
    public void sendPostInvalidCreateComplaintEndpoint() {
        createComplaint.sendPostInvalidCreateComplaintEndpoint();
    }

    @When("I send post request with valid requestBody to create complaint endpoint without login")
    public void sendPostCreateComplaintWithoutLogin() {
        createComplaint.sendPostCreateComplaintWithoutLogin();
    }

    @And("I receive my detail complaint")
    public void receiveDetailComplaint() {
        createComplaint.receiveDetailComplaint();
    }
}
