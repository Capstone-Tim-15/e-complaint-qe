package starter.stepdefinitions.notification;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.DashboardPage;
import starter.pages.FAQPage;
import starter.pages.NotificationPage;

public class NotificationSteps {
    @Steps
    DashboardPage dashboardPage;

    @Steps
    NotificationPage notificationPage;

    @Steps
    FAQPage faqPage;

    @When("I click notification")
    public void clickNotificationIcon() {
        dashboardPage.clickNotifIcon();
    }

    @Then("I am on notification page")
    public void validateOnNotificationPage() {
        notificationPage.validateOnNotificationPage();
    }

//    @And("I click detail notification")
//    public void clickDetailNotification() {
//        notificationPage.clickDetailButton();
//    }

    @And("I click FAQ button")
    public void clickFAQButton() {
        notificationPage.clickFAQButton();
    }

//    @Then("I can see detail of complaint")
//    public void seeDetailComplaint() {
//
//    }

    @Then("I am on FAQ page")
    public void onFAQPage() {
        faqPage.validateOnFAQPage();
    }
}
