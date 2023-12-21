package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class DashboardPage extends PageObject {

//TITLE
    private By titleGov() {
        return By.xpath("/html/body/div/row/div/nav/span");
    }
    private By dashboardMenu() {
        return By.xpath("//div[@class='your-class-name']/ul/li[1]/div\n");
    }

//NOTIF
    private By notifIcon() {
        return By.xpath("/html/body/div/row/div/nav/div/div[1]/div/span[1]/a/button");
    }

//COMPLAINT
    private By complaintMenu() {
        return By.xpath("/html/body/div/row/row/div[1]/div/div[1]/ul/li[2]/div/a");
    }



//LOGOUT
    private By logoutMenu() {
        return By.xpath("/html/body/div/row/row/div[1]/div/div[2]/button");
    }

    private By logoutButton() {
        return By.xpath("/html/body/div[3]/div/div/div[2]/button[2]");
    }

    private By cancelButton() {
        return By.xpath("/html/body/div[3]/div/div/div[2]/button[1]");
    }

    private By userStat() {
        return By.xpath("/html/body/div/row/row/div[2]/div[1]/div[1]/div/div[1]/div[1]/h6");
    }

    private By complaintStat() {
        return By.xpath("/html/body/div/row/row/div[2]/div[1]/div[2]/div/div[1]/div[1]/h6");
    }

    private By resolvedStat() {
        return By.xpath("/html/body/div/row/row/div[2]/div[1]/div[3]/div/div[1]/div[1]/h6");
    }

//CODESTEP
    //Title
    @Step
    public boolean validateOnDashboard() {
        return $(notifIcon()).isDisplayed();
    }

    //Notif
    @Step
    public void clickNotifIcon() {
        $(notifIcon()).click();
    }

    //Logout
    @Step
    public boolean isLogoutMenuVisible() {
        return $(logoutMenu()).isVisible();
    }

    @Step
    public void clickLogoutMenu() {
        $(logoutMenu()).click();
    }

    @Step
    public void clickLogoutButton() {
        $(logoutButton()).click();
    }

    @Step
    public void clickCancelButton() {
        $(cancelButton()).click();
    }

    @Step
    public void clickComplaintMenu() {
        $(complaintMenu()).click();
    }

    @Step
    public boolean getUserStat() {
        return $(userStat()).isDisplayed();
    }

    @Step
    public boolean getComplaintStat() {
        return $(complaintStat()).isDisplayed();
    }

    @Step
    public boolean getSolvedStat() {
        return $(resolvedStat()).isDisplayed();
    }
    @Step
    public void clickNewsButton() {
        $(newsButton()).click();
    }

}
