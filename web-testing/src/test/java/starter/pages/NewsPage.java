package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class NewsPage extends PageObject {

    private By addNewsButton() {return By.xpath("//*[@id=\"btn-tambah\"]/button");}

    private By editicon() {return By.xpath("/html/body/div/row/row/div[2]/div/div[3]/table/tbody/tr[1]/td[5]/div/button[1]");}

    private By deleteButton() {return By.xpath("/html/body/div/row/row/div[2]/div/div[3]/table/tbody/tr[2]/td[5]/div/button[2]");}

    private By yesButton() {return By.xpath("/html/body/div/row/row/div[2]/div/div[4]/div/div/div/div[3]/button[2]");}

    private By noButton() {return By.xpath("/html/body/div/row/row/div[2]/div/div[4]/div/div/div/div[3]/button[1]");}

    @Step
    public boolean validateOnTheNewsPage() {
        return $(addNewsButton()).isDisplayed();
    }

    @Step
    public void clickAddNewsButton() {$(addNewsButton()).click();}

    @Step
    public void clickIconEdit() {$(editicon()).click();}

    @Step
    public void clickDeleteButton() {$(deleteButton()).click();}

    @Step
    public void clickYes() {$(yesButton()).click();}

    @Step
    public void clickNo() {$(noButton()).click();}








}
