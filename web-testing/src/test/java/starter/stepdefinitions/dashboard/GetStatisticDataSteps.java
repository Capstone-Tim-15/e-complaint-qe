package starter.stepdefinitions.dashboard;

import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import starter.pages.DashboardPage;

public class GetStatisticDataSteps {
    @Steps
    DashboardPage dashboardPage;

    @Then("I can see the user statistic")
    public void seeUserStat() {
        dashboardPage.getUserStat();
    }

    @Then("I can see the complaint statistic")
    public void seeComplaintStat() {
        dashboardPage.getComplaintStat();
    }

    @Then("I can see the resolved category statistic")
    public void seeSolvedStat() {
        dashboardPage.getSolvedStat();
    }
}
