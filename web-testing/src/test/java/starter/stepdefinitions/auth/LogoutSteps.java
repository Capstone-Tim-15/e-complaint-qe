package starter.stepdefinitions.auth;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.DashboardPage;

public class LogoutSteps {
    @Steps
    DashboardPage dashboardPage;

    @When("I click logout menu")
    public void clickLogoutMenu() {
        dashboardPage.clickLogoutMenu();
    }

    @And("I click logout")
    public void clickLogout() {
        dashboardPage.clickLogoutButton();
    }

    @And("I click cancel")
    public void clickCancel() {
        dashboardPage.clickCancelButton();
    }
}
