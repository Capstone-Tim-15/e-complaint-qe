package org.example.app.pages;

import io.appium.java_client.AppiumBy;
import org.example.app.base.BasePageObject;

public class DashboardPage extends BasePageObject {

    public boolean getGovComplaintTitle() {
        return
                isDisplayed(AppiumBy.xpath("//android.view.View[@content-desc=\"GOV-Complaint\"]"));
    }

    public void clickCreateComplaint() {
        click(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.Button"));
    }

    public void clickRecentNews(){
        click(AppiumBy.xpath("//android.view.View[@content-desc=\"Zara\n" +
                "12-15\n" +
                "berita seputar pendidikan\n" +
                "20\n" +
                "16\"]"));
    }

    public void clickChatAdmin() {
        click(AppiumBy.xpath("//android.view.View[@content-desc=\"GOV-Complaint\"]/android.widget.ImageView[2]"));
    }

    public void clickProfileIcon() {
        click(AppiumBy.xpath("//android.view.View[@content-desc=\"Profile\n" +
                "Tab 4 of 4\"]"));
    }

    public void clickNotifIcon() {
        click(AppiumBy.xpath("//android.view.View[@content-desc=\"Notification\n" +
                "Tab 3 of 4\"]"));
    }

    public void clickSearchIcon() {
        click(AppiumBy.xpath("//android.view.View[@content-desc=\"Search\n" +
                "Tab 2 of 4\"]"));
    }

    public void clickHomeIcon() {
        click(AppiumBy.xpath("//android.view.View[@content-desc=\"Home\n" +
                "Tab 1 of 4\"]"));
    }


}
