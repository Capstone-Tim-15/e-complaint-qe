package starter.stepdefinitions.user.complaint;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.gocat.user.complaint.GetAllComplaint;

public class GetAllComplaintSteps {
    @Steps
    GetAllComplaint getAllComplaint;

    @Given("I set {string} endpoint for get all complaint")
    public void setEndpointGetAllComplaint(String endpointType) {
        getAllComplaint.setEndpointGetAllComplaint(endpointType);
    }

    @When("I send get request to {string} get all complaint endpoint")
    public void sendGetBaseTypeGetAllComplaintEndpoint(String baseType) {
        getAllComplaint.sendGetBaseTypeGetAllComplaintEndpoint(baseType);
    }

    @And("I receive list of complaint")
    public void receiveListComplaint() {
        getAllComplaint.receiveListComplaint();
    }

    @And("I receive null complaint result")
    public void receiveNullComplaintResult() {
        getAllComplaint.receiveNullComplaintResult();
    }
}
