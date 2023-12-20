package starter.stepdefinitions.admin.dashboard;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.gocat.admin.dashboard.GetComplaintStatistic;

public class GetComplaintStatisticSteps {
    @Steps
    GetComplaintStatistic getComplaintStatistic;

    @Given("I set {string} endpoint for get complaint statistic")
    public void setEndpointTypeGetComplaintStatistic(String endpointType) {
        getComplaintStatistic.setEndpointTypeGetComplaintStatistic(endpointType);
    }

    @When("I send get request to {string} get complaint statistic endpoint")
    public void sendGetBaseTypeGetComplaintStatEndpoint(String baseType) {
        getComplaintStatistic.sendGetBaseTypeGetComplaintStatEndpoint(baseType);
    }

    @When("I send get request to valid get complaint statistic endpoint without token")
    public void getComplaintStatWithoutToken() {
        getComplaintStatistic.getComplaintStatWithoutToken();
    }

    @And("I receive the complaint statistic")
    public void receiveComplaintStat() {
        getComplaintStatistic.receiveComplaintStat();
    }
}
