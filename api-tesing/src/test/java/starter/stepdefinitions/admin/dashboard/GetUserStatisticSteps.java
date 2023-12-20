package starter.stepdefinitions.admin.dashboard;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.gocat.admin.dashboard.GetUserStatistic;

public class GetUserStatisticSteps {
    @Steps
    GetUserStatistic getUserStatistic;

    @Given("I set {string} endpoint for get user statistic")
    public void setEndpointTypeGetUserStatistic(String endpointType) {
        getUserStatistic.setEndpointTypeGetUserStatistic(endpointType);
    }

    @When("I send get request to {string} get user statistic endpoint")
    public void sendGetBaseTypeGetUserStatEndpoint(String baseType) {
        getUserStatistic.sendGetBaseTypeGetUserStatEndpoint(baseType);
    }

    @When("I send get request to valid get user statistic endpoint without token")
    public void getUserStatWithoutToken() {
        getUserStatistic.getUserStatWithoutToken();
    }

    @And("I receive the user statistic")
    public void receiveUserStat() {
        getUserStatistic.receiveUserStat();
    }
}
