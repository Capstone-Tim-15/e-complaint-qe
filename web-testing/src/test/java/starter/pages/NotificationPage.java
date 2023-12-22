package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class NotificationPage extends PageObject {

    private By titleNotification() {
        return By.xpath("/html/body/div/row/row/div[2]/div/h3");
    }

//    private By detailButton() {
//        return By.xpath("/html/body/div/row/row/div[2]/div/div[2]/p[2]/span[2]/button");
//    }
//
//    private By closeButton() {
//        return By.xpath("/html/body/div[3]/div/div/div[3]/button");
//    }

    private By FAQButton() {
        return By.xpath("/html/body/div/div/div/a/svg");
    }

    @Step
    public boolean validateOnNotificationPage() {
        return $(titleNotification()).isDisplayed();
    }

//    @Step
//    public void clickDetailButton() {
//        $(detailButton()).click();
//    }
//
//    @Step
//    public void clickCloseButton() {
//        $(closeButton()).click();
//    }

    @Step
    public void clickFAQButton() {
        $(FAQButton()).click();
    }
}
