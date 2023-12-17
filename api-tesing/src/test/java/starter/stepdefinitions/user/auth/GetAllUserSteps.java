package starter.stepdefinitions.user.auth;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.gocat.user.auth.GetAllUser;

public class GetAllUserSteps {
    @Steps
    GetAllUser getAllUser;

    @Given("I set {string} endpoint for get all user")
    public void setEndpointGetAllUser(String endpointType) {
        getAllUser.setEndpointGetAllUser(endpointType);
    }

    @When("I send get request to {string} get all user endpoint")
    public void sendGetAllPostToBaseTypeEndpoint(String baseType) {
        getAllUser.sendGetAllPostToBaseTypeEndpoint(baseType);
    }

    @When("I send {string} request to get all user")
    public void sendOtherMethodToGetAllUser(String methodType) {
        getAllUser.sendOtherMethodToGetAllUser(methodType);
    }

    @And("I receive list of user")
    public void receiveListOfUser() {
        getAllUser.receiveListOfUser();
    }


}
