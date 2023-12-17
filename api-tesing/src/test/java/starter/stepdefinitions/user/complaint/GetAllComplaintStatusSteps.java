package starter.stepdefinitions.user.complaint;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.gocat.user.complaint.GetAllComplaintStatus;

public class GetAllComplaintStatusSteps {
    @Steps
    GetAllComplaintStatus getAllComplaintStatus;

    @Given("I set {string} endpoint for get all complaint status")
    public void setEndpointGetAllComplaintStatus(String endpointType) {
        getAllComplaintStatus.setEndpointGetAllComplaintStatus(endpointType);
    }

    @When("I send get request to {string} get all complaint status endpoint")
    public void sendGetBaseTypeGetAllComplaintEndpoint(String baseType) {
        getAllComplaintStatus.sendGetBaseTypeGetAllComplaintStatusEndpoint(baseType);
    }

    @And("I receive list of complaint status")
    public void receiveListComplaintStatus() {
        getAllComplaintStatus.receiveListComplaintStatus();
    }

}
