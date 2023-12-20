package starter.stepdefinitions.Complaint;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import starter.pages.ComplaintPage;

public class GetComplaintByStatusSteps {
    @Steps
    ComplaintPage complaintPage;

    @And("I click category complaint dropdown")
    public void clickCategoryComplaint() {
        complaintPage.clickCategoryComplaint();
    }

    @And("I choose category complaint to {string}")
    public void chooseCategoryComplaint(String categoryType) {
        complaintPage.chooseCategoryType(categoryType);
    }

    @Then("The complaint will be sorted by {string}")
    public void complaintSorted(String validateGetByStatusType) {
        complaintPage.validateGetByStatus(validateGetByStatusType);
    }
}
