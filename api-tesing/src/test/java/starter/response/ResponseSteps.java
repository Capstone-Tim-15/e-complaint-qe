package starter.response;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class ResponseSteps {

    @Steps
    ResponseBody responseBody;


    @Then("I receive status code 201")
    public void receiveStatusCode201() {
        responseBody.receiveStatusCode201();
    }

    @Then("I receive status code 200")
    public void receiveStatusCode200() {
        responseBody.receiveStatusCode200();
    }

    @Then("I receive status code 400")
    public void receiveStatusCode400() {
        responseBody.receiveStatusCode400();
    }

    @Then("I receive status code 401")
    public void receiveStatusCode401() {
        responseBody.receiveStatusCode401();
    }

    @Then("I receive status code 404")
    public void receiveStatusCode404() {
        responseBody.receiveStatusCode404();
    }

    @Then("I receive status code 409")
    public void receiveStatusCode409() {
        responseBody.receiveStatusCode409();
    }

    @Then("I receive status code 500")
    public void receiveStatusCode500() {
       responseBody.receiveStatusCode500();
    }

    @And("I receive auth error message")
    public void receiveAuthErrorMessage() {
        responseBody.receiveAuthErrorMessage();
    }

    @And("I receive error message")
    public void receiveErrorMessage() {
        responseBody.receiveErrorMessage();
    }

}
