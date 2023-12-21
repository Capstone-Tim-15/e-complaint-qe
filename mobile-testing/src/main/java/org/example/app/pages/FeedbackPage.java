package org.example.app.pages;

import io.appium.java_client.AppiumBy;
import org.example.app.base.BasePageObject;

public class FeedbackPage extends BasePageObject{
    public boolean validateOnFeedbackPage() {
        return
                isDisplayed(AppiumBy.xpath("//android.view.View[@content-desc=\"Postingan Berita\"]"));
    }
    public boolean validateFeedbackIsDisplayed() {
        return
                isDisplayed(AppiumBy.xpath("//android.view.View[@content-desc=\"ini content feedback\"]"));
    }

}
