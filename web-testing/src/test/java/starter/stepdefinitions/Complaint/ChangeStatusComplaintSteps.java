package starter.stepdefinitions.Complaint;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Assertions;
import starter.pages.ComplaintPage;
import starter.pages.DashboardPage;

public class ChangeStatusComplaintSteps {
    @Steps
    DashboardPage dashboardPage;

    @Steps
    ComplaintPage complaintPage;

    @When("I click complaint menu")
    public void clickComplaintMenu() {
        dashboardPage.clickComplaintMenu();
        Assertions.assertTrue(complaintPage.validateOnComplaintPage());
    }

    @And("I click change status icon")
    public void clickChangeStatusIcon() {
        complaintPage.clickChangeStatusIcon();
    }

    @And("I changed the complaint status to {string}")
    public void changeComplaintStatus(String statusType) {
        complaintPage.chooseStatusType(statusType);
    }

    @And("I click change button")
    public void clickChangeButton() {
        complaintPage.clickChangeButton();
    }

    @And("I click close button")
    public void clickCloseButton() {
        complaintPage.clickCloseButton();
    }

    @Then("The status has changed to {string}")
    public void statusHasChanged(String validateStatusType) {
        complaintPage.validateType(validateStatusType);
    }

    @Then("I am on complaint page")
    public void onComplaintPage() {
       Assertions.assertTrue(complaintPage.validateOnComplaintPage());
    }
}
