package starter.stepdefinitions.admin.dashboard;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.gocat.admin.dashboard.GetSolvedStatistic;

public class GetSolvedStatisticSteps {
    @Steps
    GetSolvedStatistic getSolvedStatistic;

    @Given("I set {string} endpoint for get solved statistic")
    public void setEndpointTypeGetSolvedStatistic(String endpointType) {
        getSolvedStatistic.setEndpointTypeGetSolvedStatistic(endpointType);
    }

    @When("I send get request to {string} get solved statistic endpoint")
    public void sendGetBaseTypeGetSolvedStatEndpoint(String baseType) {
        getSolvedStatistic.sendGetBaseTypeGetSolvedStatEndpoint(baseType);
    }

    @When("I send get request to valid get solved statistic endpoint without token")
    public void getSolvedStatWithoutToken() {
        getSolvedStatistic.getSolvedStatWithoutToken();
    }

    @And("I receive the solved statistic")
    public void receiveSolvedStat() {
        getSolvedStatistic.receiveSolvedStat();
    }
}
