package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class FAQPage extends PageObject {

    private By titleFAQ() {
        return By.xpath("/html/body/div/row/row/div[2]/div/h3");
    }

    @Step
    public boolean validateOnFAQPage() {
        return $(titleFAQ()).isDisplayed();
    }
}
