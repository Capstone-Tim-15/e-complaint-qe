package starter.stepdefinitions.news;

import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;
import starter.pages.NewsPage;

public class DeleteNewsSteps {

    @Steps
    NewsPage newsPage;

    @When("I click delete button")
    public void clickDeleteButton() {newsPage.clickDeleteButton();}

    @And("I click yes button")
    public void clickYes() {newsPage.clickYes();}

    @And("I click no button")
    public void clickNo() {newsPage.clickNo();}


}
