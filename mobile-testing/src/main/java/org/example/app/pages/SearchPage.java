package org.example.app.pages;

import io.appium.java_client.AppiumBy;
import org.example.app.base.BasePageObject;

public class SearchPage extends BasePageObject {
    public void clickInfrastructureCategory() {
        click(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Infrastruktur\"]"));
    }

    public void inputCategory(String category) {
        type(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText"), category);
    }

    public void clickComplaintTab() {
        click(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Keluhan\"]"));
    }

    public boolean getComplaintByCategory() {
        return
                isDisplayed(AppiumBy.xpath("//android.view.View[@content-desc=\"anisa\n" +
                        "2023-12-18\n" +
                        "Jalan Duyung, Kota Batam\n" +
                        "content pohon tumbang di jalan A\"]"));
    }

    public void clickNewsTab() {
        click(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Berita\"]"));
    }

    public boolean getNewsByCategory() {
        return
                isDisplayed(AppiumBy.xpath("//android.view.View[@content-desc=\"Tidak dapat menemukan data berita\"]"));
    }


}
