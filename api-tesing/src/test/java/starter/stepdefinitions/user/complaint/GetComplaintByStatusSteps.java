package starter.stepdefinitions.user.complaint;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.gocat.user.complaint.GetComplaintByStatus;

public class GetComplaintByStatusSteps {
    @Steps
    GetComplaintByStatus getComplaintByStatus;

    @Given("I set {string} endpoint for get complaint by status")
    public void setEndpointGetAllComplaintStatus(String endpointType) {
        getComplaintByStatus.setEndpointGetAllComplaintStatus(endpointType);
    }

    @When("I send get request to {string} get complaint by status endpoint")
    public void sendGetBaseTypeGetAllComplaintEndpoint(String baseType) {
        getComplaintByStatus.sendGetBaseTypeGetAllComplaintStatusEndpoint(baseType);
    }

    @And("I receive list of unsolved complaint")
    public void receiveListUnsolvedComplaint() {
        getComplaintByStatus.receiveListUnsolvedComplaint();
    }

    @And("I receive list of solved complaint")
    public void receiveListSolvedComplaint() {
        getComplaintByStatus.receiveListSolvedComplaint();
    }

}
