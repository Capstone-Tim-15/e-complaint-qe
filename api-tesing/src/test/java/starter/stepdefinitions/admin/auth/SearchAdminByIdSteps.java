package starter.stepdefinitions.admin.auth;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.gocat.admin.auth.SearchAdminById;

public class SearchAdminByIdSteps {
    @Steps
    SearchAdminById searchAdminById;

    @Given("I set {string} for search admin by id")
    public void setEndpointSearchAdminById(String endpointType) {
        searchAdminById.setEndpointSearchAdminById(endpointType);
    }

    @When("I send get request to {string} search admin by id endpoint")
    public void sendGetSearchAdminByIdToBaseTypeEndpoint(String baseType) {
        searchAdminById.sendGetSearchAdminByIdToBaseTypeEndpoint(baseType);
    }

    @When("I send get request to valid search admin by id endpoint without login")
    public void sendGetToSearchAdminByIdWithoutLogin() {
        searchAdminById.sendGetToSearchAdminByIdWithoutLogin();
    }

    @And("I receive that admin detail account")
    public void receiveAdminDetailAccount() {
        searchAdminById.receiveAdminDetailAccount();
    }
}
