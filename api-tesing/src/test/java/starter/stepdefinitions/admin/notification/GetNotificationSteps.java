package starter.stepdefinitions.admin.notification;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.gocat.admin.notification.GetNotification;

public class GetNotificationSteps {
    @Steps
    GetNotification getNotification;

    @Given("I set {string} endpoint for get notif")
    public void setEndpointTypeGetNotif(String endpointType) {
        getNotification.setEndpointTypeGetNotifistic(endpointType);
    }

    @When("I send get request to {string} get notif endpoint")
    public void sendGetBaseTypeGetNotifEndpoint(String baseType) {
        getNotification.sendGetBaseTypeGetNotifEndpoint(baseType);
    }

    @When("I send get request to valid get notif endpoint without token")
    public void getNotifWithoutToken() {
        getNotification.getNotifWithoutToken();
    }

    @And("I receive the notif")
    public void receiveNotif() {
        getNotification.receiveNotif();
    }
}
