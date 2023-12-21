package org.example.app.pages;

import io.appium.java_client.AppiumBy;
import org.example.app.base.BasePageObject;

public class ProfilPage extends BasePageObject {
    public boolean getProfileTitle() {
        return
                isDisplayed(AppiumBy.xpath("//android.view.View[@content-desc=\"Profil\"]"));
    }

    public void clickComplaintStatus() {
        click(AppiumBy.xpath("//android.view.View[@content-desc=\"Status Pengaduan\"]"));
    }

    public boolean getComplaintHistoryTitle() {
        return
                isDisplayed(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Riwayat Pengaduan\"]"));
    }

    public void clickSendTab() {
        click(AppiumBy.xpath("//android.view.View[@content-desc=\"Terkirim\n" +
                "Tab 1 of 3\"]"));
    }

    public boolean getSentComplaint() {
        return
                isDisplayed(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Infrastruktur\n" +
                        "test\"]"));
    }

    public void clickProcessedTab() {
        click(AppiumBy.xpath("//android.view.View[@content-desc=\"Diproses\n" +
                "Tab 2 of 3\"]"));
    }

    public boolean getProcessedComplaint() {
        return
                isDisplayed(AppiumBy.xpath("(//android.widget.ImageView[@content-desc=\"cat1\n" +
                        "test.\"])[1]"));
    }

    public void clickCompletedTab() {
        click(AppiumBy.xpath("//android.view.View[@content-desc=\"Selesai\n" +
                "Tab 3 of 3\"]"));
    }

    public boolean getCompletedComplaint() {
        return
                isDisplayed(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Infrastruktur\n" +
                        "test\"]"));
    }


}
