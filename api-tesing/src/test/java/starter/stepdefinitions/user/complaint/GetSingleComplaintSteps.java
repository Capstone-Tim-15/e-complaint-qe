package starter.stepdefinitions.user.complaint;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.gocat.user.complaint.GetSingleComplaint;

public class GetSingleComplaintSteps {
    @Steps
    GetSingleComplaint getSingleComplaint;

    @Given("I set {string} endpoint for get single complaint")
    public void setEndpointGetSingleComplaint (String endpointType){
        getSingleComplaint.setEndpointGetSingleComplaint(endpointType);
    }

    @When("I send get request to {string} get single complaint endpoint")
    public void sendGetBaseTypeGetSingleComplaintEndpoint(String baseType) {
        getSingleComplaint.sendGetBaseTypeGetSingleComplaintEndpoint(baseType);
    }

    @And("I receive detail complaint")
    public void receiveDetailComplaint() {
        getSingleComplaint.receiveDetailComplaint();
    }
}
