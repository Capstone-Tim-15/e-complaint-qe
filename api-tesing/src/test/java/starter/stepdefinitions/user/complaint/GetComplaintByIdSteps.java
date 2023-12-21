package starter.stepdefinitions.user.complaint;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.gocat.user.complaint.GetComplaintById;

public class GetComplaintByIdSteps {
    @Steps
    GetComplaintById getComplaintById;

    @Given("I set {string} endpoint for get complaint by id")
    public void setEndpointGetSingleComplaint (String endpointType){
        getComplaintById.setEndpointGetSingleComplaint(endpointType);
    }

    @When("I send get request to {string} get complaint by id endpoint")
    public void sendGetBaseTypeGetSingleComplaintEndpoint(String baseType) {
        getComplaintById.sendGetBaseTypeGetSingleComplaintEndpoint(baseType);
    }

    @And("I receive list of complaint by Id")
    public void receiveDetailComplaint() {
        getComplaintById.receiveDetailComplaint();
    }
}
