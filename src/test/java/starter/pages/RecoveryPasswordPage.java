package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class RecoveryPasswordPage extends PageObject {
    private By recoveryPasswordTitle() {
        return By.xpath("/html/body/div/div/div/div[2]");
    }

    private By emailField() {
        return By.xpath("/html/body/div/div/div/input");
    }

    private By nextButton() {
        return By.xpath("/html/body/div/div/div/button");
    }

    private By missingEmailErrMssg() {
        return By.xpath("/html/body/div/div/div/div/div[1]/div[2]");
    }
}
