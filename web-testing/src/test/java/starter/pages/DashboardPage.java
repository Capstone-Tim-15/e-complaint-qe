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
        return By.xpath("/html/body/div/row/row/div[1]/div/div[1]/ul/li[1]/div/a");
    }

//NOTIF
    private By notifIcon() {
        return By.className("iconify iconify--ion");
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


//CODESTEP
    //Title
    @Step
    public boolean validateOnDashboard() {
        return $(dashboardMenu()).isDisplayed();
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

}