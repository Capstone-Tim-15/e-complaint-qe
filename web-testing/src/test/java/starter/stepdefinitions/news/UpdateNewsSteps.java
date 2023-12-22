package starter.stepdefinitions.news;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Assertions;
import starter.pages.CreateNewsPage;
import starter.pages.NewsPage;

public class UpdateNewsSteps {

    @Steps
    NewsPage newsPage;
    @Steps
    CreateNewsPage createNewsPage;

    @When("I click icon edit")
    public void clickIconEdit() {newsPage.clickIconEdit();}

    @And("I delete date before")
    public void deleteDate() {createNewsPage.deleteDate();}

    @And("I delete news title before")
    public void deleteTitle() {createNewsPage.deleteTitle();}

    @And("I delete news content")
    public void deleteContent() {createNewsPage.deleteContent();}

    @Then("I redirected to the news page")
    public void onTheNewsPage() {
        Assertions.assertTrue(newsPage.validateOnTheNewsPage());}


}
