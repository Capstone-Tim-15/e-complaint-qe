package starter.stepdefinitions.admin.auth;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.gocat.admin.auth.SearchAdminByName;

public class SearchAdminByNameSteps {
    @Steps
    SearchAdminByName searchAdminByName;

    @Given("I set {string} for search admin by name")
    public void setEndpointSearchAdminByName(String endpointNameType) {
        searchAdminByName.setEndpointSearchAdminByName(endpointNameType);
    }

    @When("I send get request to {string} search admin by name endpoint")
    public void sendGetSearchAdminByNameToBaseTypeEndpoint(String baseType) {
        searchAdminByName.sendGetSearchAdminByNameToBaseTypeEndpoint(baseType);
    }

    @When("I send get request to valid search admin by name endpoint without login")
    public void sendGetToSearchAdminByNameWithoutLogin() {
        searchAdminByName.sendGetToSearchAdminByNameWithoutLogin();
    }
}