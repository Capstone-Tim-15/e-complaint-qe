package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class CreateNewsPage extends PageObject {

    private By dateFields() {return By.xpath("/html/body/div/row/row/div[2]/div[2]/form/div[1]/div/input");}

    private By titleFields() {return By.xpath("/html/body/div/row/row/div[2]/div[2]/form/div[2]/div/input");}

    private By contentFields() {return By.xpath("/html/body/div/row/row/div[2]/div[2]/form/div[3]/div/textarea");}

    private By fileContentFields() {return By.xpath("/html/body/div/row/row/div[2]/div[2]/form/div[4]/div/input");}

    private By saveButton() {return By.xpath("/html/body/div/row/row/div[2]/div[2]/form/div[5]/div/button");}

    private By uploadButton() {
        return By.xpath("//button[contains(text(),'Choose File')]");
    }

    @Step
    public boolean validateOnTheCreateNewsPage() {
        return $(saveButton()).isDisplayed();
    }

    @Step
    public void inputValidDate() {
        $(dateFields()).type("02082023");
    }

    @Step
    public void inputValidTitle() {
        $(titleFields()).type("Mark Lee");
    }

    @Step
    public void inputValidContent() {
        $(contentFields()).type("Mark Lee");
    }

    @Step
    public void inputValidContentFile() {
        WebElement uploadElement = $(uploadButton());
        uploadElement.sendKeys("\u202AC:\\Users\\User\\Downloads\\download.jpeg");
        $(fileContentFields()).click();
    }


    @Step
    public void clickSaveButton() {
        $(saveButton()).click();
    }

    @Step
    public boolean ValidateOnTheCreateNewsPage() {
        return $(saveButton()).isDisplayed();
    }

    @Step
    public void inputInvalidDate() {
        $(dateFields()).type("");
    }

    @Step
    public void inputInvalidTitle() {
        $(titleFields()).type("");
    }

    @Step
    public void inputInvalidContent() {
        $(contentFields()).type("");
    }

    @Step
    public void inputInvalidContentFile() {

    }





}
