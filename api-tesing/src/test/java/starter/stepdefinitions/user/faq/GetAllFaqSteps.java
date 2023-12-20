package starter.stepdefinitions.user.faq;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.gocat.user.faq.GetAllFaq;

public class GetAllFaqSteps {
    @Steps
    GetAllFaq getAllFaq;

    @Given("I set {string} endpoint for get all faq")
    public void setEndpointGetAllFaq(String endpointType) {
        getAllFaq.setEndpointGetAllFaq(endpointType);
    }

    @When("I send get request to {string} get all faq endpoint")
    public void sendGetBaseTypeGetAllFaqEndpoint(String baseType) {
        getAllFaq.sendGetBaseTypeGetAllFaqEndpoint(baseType);
    }

    @When("I send get request to valid get all faq endpoint without token")
    public void sendGetAllFaqWithoutToken() {
        getAllFaq.sendGetAllFaqWithoutToken();
    }

    @And("I receive list of faq")
    public void receiveListFaq() {
        getAllFaq.receiveListFaq();
    }

}
