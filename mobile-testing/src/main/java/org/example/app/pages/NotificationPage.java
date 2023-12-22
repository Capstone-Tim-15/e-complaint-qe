package org.example.app.pages;

import io.appium.java_client.AppiumBy;
import org.example.app.base.BasePageObject;

public class NotificationPage extends BasePageObject {
    public boolean validateOnNotificationPage() {
        return
                isDisplayed(AppiumBy.xpath("//android.view.View[@content-desc=\"Notifikasi\"]"));
    }

    public boolean validateNotifIsDisplayed() {
        return
                isDisplayed(AppiumBy.xpath("(//android.view.View[@content-desc=\"Status Pengaduan\n" +
                        "Pengaduan anda tentang kerusakan jalan telah diterima. saat ini tim kami sedang meninjau masalah.\n" +
                        "1 jam lalu\"])[1]"));
    }
}
