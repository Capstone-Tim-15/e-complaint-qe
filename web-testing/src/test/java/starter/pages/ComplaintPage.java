package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ComplaintPage extends PageObject {
    private By complaintTitle() {
        return By.xpath("//*[@id=\"judul\"]");
    }

    private By changeStatusIcon() {
        return By.xpath("/html/body/div/row/row/div[2]/div/table/tbody/tr[2]/td[6]/div/button[2]");
    }

    private By sendStatus() {
        return By.xpath("/html/body/div/div/div/div/div[2]/form/div[2]/label/select/option[2]");
    }

    private By processedStatus() {
        return By.xpath("/html/body/div/div/div/div/div[2]/form/div[2]/label/select/option[3]");
    }

    private By completedStatus() {
        return By.xpath("/html/body/div/div/div/div/div[2]/form/div[2]/label/select/option[4]");
    }

    private By deleteIcon() {
        return By.xpath("/html/body/div/row/row/div[2]/div/table/tbody/tr[2]/td[6]/div/button[3]");
    }

    private By changeButton() {
        return By.xpath("/html/body/div/div/div/div/div[2]/form/div[3]/button[2]");
    }

    private By closeButton() {
        return By.xpath("/html/body/div/div/div/div/div[2]/form/div[3]/button[1]");
    }

    //CATEGORY
    private By categoryComplaint() {
        return By.xpath("/html/body/div/row/row/div[2]/div/div[1]/div/div[2]/div[2]/select");
    }

    private By sendCategory() {
        return By.xpath("/html/body/div/row/row/div[2]/div/div[1]/div/div[2]/div[2]/select/option[2]");
    }

    private By processedCategory() {
        return By.xpath("/html/body/div/row/row/div[2]/div/div[1]/div/div[2]/div[2]/select/option[3]");
    }

    private By completedCategory() {
        return By.xpath("/html/body/div/row/row/div[2]/div/div[1]/div/div[2]/div[2]/select/option[4]");
    }



    //validateStatusHasChanged
    private By validateSendStatus() {
        return By.xpath("/html/body/div/row/row/div[2]/div/table/tbody/tr[3]/td[5]/div");
    }

    private By validateProcessedStatus() {
        return By.xpath("/html/body/div/row/row/div[2]/div/table/tbody/tr[1]/td[5]/div");
    }

    private By validateCompletedStatus() {
        return By.xpath("/html/body/div/row/row/div[2]/div/table/tbody/tr[2]/td[5]/div");
    }

    //validateGetByCategory
    private By validateGetBySendStatus() {
        return By.xpath("/html/body/div/row/row/div[2]/div/table/tbody/tr[1]/td[5]/div");
    }

    private By validateGetByProcessedStatus() {
        return By.xpath("/html/body/div/row/row/div[2]/div/table/tbody/tr/td[5]/div");
    }

    private By validateGetByCompletedStatus() {
        return By.xpath("/html/body/div/row/row/div[2]/div/table/tbody/tr[1]/td[5]/div");
    }


    @Step
    public boolean validateOnComplaintPage() {
        return $(complaintTitle()).isDisplayed();
    }

    @Step
    public void clickChangeStatusIcon() {
        $(changeStatusIcon()).click();
    }

    @Step
    public void chooseStatusType(String statusType) {
        switch (statusType) {
            case "SEND":
                $(sendStatus()).click();
                break;
            case "Diproses":
                $(processedStatus()).click();
                break;
            case "Selesai":
                $(completedStatus()).click();
                break;
            default:
                Assert.fail("Unsupported status type: " + statusType);
        }
    }

    @Step
    public void chooseCategoryType(String categoryType) {
        switch (categoryType) {
            case "SEND":
                $(sendCategory()).click();
                break;
            case "Diproses":
                $(processedCategory()).click();
                break;
            case "Selesai":
                $(completedCategory()).click();
                break;
            default:
                Assert.fail("Unsupported category type: " + categoryType);
        }
    }

    @Step
    public boolean validateType(String validateStatusType) {
        switch (validateStatusType) {
            case "SEND":
                $(validateSendStatus()).click();
                break;
            case "Diproses":
                $(validateProcessedStatus()).click();
                break;
            case "Selesai":
                $(validateCompletedStatus()).click();
                break;
            default:
                Assert.fail("Unsupported status type: " + validateStatusType);
        }
        return false;
    }

    @Step
    public boolean validateGetByStatus(String validateGetByStatusType) {
        switch (validateGetByStatusType) {
            case "SEND":
                $(validateGetBySendStatus()).click();
                break;
            case "Diproses":
                $(validateGetByProcessedStatus()).click();
                break;
            case "Selesai":
                $(validateGetByCompletedStatus()).click();
                break;
            default:
                Assert.fail("Unsupported status type: " + validateGetByStatusType);
        }
        return false;
    }

    @Step
    public void clickChangeButton() {
        $(changeButton()).click();
    }

    @Step
    public void clickCloseButton() {
        $(closeButton()).click();
    }

    @Step
    public void clickDeleteIcon() {
        $(deleteIcon()).click();
    }

    @Step
    public void clickCategoryComplaint() {
        $(categoryComplaint()).click();
    }
}
