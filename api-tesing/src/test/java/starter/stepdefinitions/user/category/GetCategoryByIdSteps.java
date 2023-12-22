package starter.stepdefinitions.user.category;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.gocat.user.category.GetCategoryById;

public class GetCategoryByIdSteps {
    @Steps
    GetCategoryById getCategoryById;

    @Given("I set {string} endpoint for get category by id")
    public void setEndpointGetCategoryById(String endpointType) {
        getCategoryById.setEndpointGetCategoryById(endpointType);
    }

    @When("I send get request to {string} get category by id endpoint")
    public void sendGetBaseTypeGetCategoryByIdEndpoint(String baseType) {
        getCategoryById.sendGetBaseTypeGetCategoryByIdEndpoint(baseType);
    }

    @When("I send get request to valid get category by id endpoint without token")
    public void  getCategoryByIdWithoutToken() {
        getCategoryById.getCategoryByIdWithoutToken();
    }

    @And("I receive detail category")
    public void receiveDetailCategory() {
        getCategoryById.receiveDetailCategory();
    }
}
