package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ResetPasswordPage extends PageObject {
    private By resetPasswordTitle() {
        return By.xpath("/html/body/div[3]/div/div/div[1]/p");
    }

    private By verificationCodeField() {
        return By.xpath("/html/body/div[3]/div/div/div[2]/input");
    }

    private By nextButton() {
        return By.xpath("/html/body/div[3]/div/div/div[3]/button");
    }

    private By closeButton() {
        return By.xpath("/html/body/div[3]/div/div/div[1]/button");
    }

    private By missingOTPErrMssg() {
        return By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]");
    }
}
