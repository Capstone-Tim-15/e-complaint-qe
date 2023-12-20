package starter.stepdefinitions.user.category;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.gocat.user.category.GetAllCategory;

public class GetAllCategorySteps {
    @Steps
    GetAllCategory getAllCategory;

    @Given("I set {string} endpoint for get all category")
    public void setEndpointGetAllCategory(String endpointType) {
        getAllCategory.setEndpointGetAllCategory(endpointType);
    }

    @When("I send get request to {string} get all category endpoint")
    public void sendGetBaseTypeGetAllCategoryEndpoint(String baseType) {
        getAllCategory.sendGetBaseTypeGetAllCategoryEndpoint(baseType);
    }

    @When("I send get request to valid get all category endpoint without token")
    public void  getAllCategoryWithoutToken() {
        getAllCategory.getAllCategoryWithoutToken();
    }

    @And("I receive list of category")
    public void receiveListCategory() {
        getAllCategory.receiveListCategory();
    }
}
