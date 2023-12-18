package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class NewsPage extends PageObject {

    private By addNewsButton() {return By.xpath("/html/body/div/row/row/div[2]/div/div[1]/div[2]/button");}

    @Step
    public boolean validateOnTheNewsPage() {
        return $(addNewsButton()).isDisplayed();
    }

    @Step
    public void clickAddNewsButton() {$(addNewsButton()).click();}





}
