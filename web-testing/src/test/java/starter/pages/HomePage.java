package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class HomePage extends PageObject {

    private By logoGovComplaint() {
        return By.xpath("/html/body/div/header/div/div/div/div[1]/a/img");
    }

    private By loginMenu() {
        return By.xpath("/html/body/div/section[1]/div/div/div[1]/div/div/button");
    }

    @Step
    public boolean validateOnHomePage() {
        return $(logoGovComplaint()).isDisplayed();
    }

    @Step
    public void clickLoginMenu() {
        $(loginMenu()).click();
    }
}
