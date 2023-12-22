package starter.stepdefinitions.news;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Assertions;
import starter.pages.CreateNewsPage;
import starter.pages.DashboardPage;
import starter.pages.NewsPage;

public class CreateNewsSteps {

    @Steps
    DashboardPage dashboardPage;

    @Steps
    NewsPage newsPage;

    @Steps
    CreateNewsPage createNewsPage;

    @When("I click news button")
    public void clickNewsButton() {dashboardPage.clickNewsButton();}

    @Then("I am on the news page")
    public void onTheNewsPage() {Assertions.assertTrue(newsPage.validateOnTheNewsPage());}

    @When("I click add news button")
    public void clickAddNewsButton() {newsPage.clickAddNewsButton();}

    @Then("I am on the create news page")
    public void onTheCreateNewsPage() {
        Assertions.assertTrue(createNewsPage.validateOnTheCreateNewsPage());
    }

    @And("I enter valid date")
    public void inputValidDate() {createNewsPage.inputValidDate();}

    @And("I enter valid news title")
    public void inputValidTitle() {createNewsPage.inputValidTitle();}

    @And("I enter valid news content")
    public void inputValidContent() {createNewsPage.inputValidContent();}

    @And("I enter valid file for news content")
    public void inputValidContentFile() {createNewsPage.inputValidContentFile();}

    @And("I click save button")
    public void clickSaveButton() {createNewsPage.clickSaveButton();}

    @And("I redirected to")
    public void onTheCreateNews() {Assertions.assertTrue(createNewsPage.ValidateOnTheCreateNewsPage());}

    @And("I enter invalid date")
    public void inputInvalidDate() {createNewsPage.inputInvalidDate();}

    @And("I enter invalid news title")
    public void inputInvalidTitle() {createNewsPage.inputInvalidTitle();}

    @And("I enter invalid news content")
    public void inputInvalidContent() {createNewsPage.inputInvalidContent();}

    @And("I enter invalid file for news content")
    public void inputInvalidContentFile() {createNewsPage.inputInvalidContentFile();}

}
