package org.example.app.pages;

import io.appium.java_client.AppiumBy;
import org.example.app.base.BasePageObject;

public class GovComplaintPage extends BasePageObject {
    public boolean intro1() {
        return
           isDisplayed(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Mari Berpartisipasi dalam penyaluran pelayanan publik\"]"));

    }

    public boolean intro2() {
        return
                isDisplayed(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Laporkan masalah dan ajukan pengaduan masalah yang Anda alami\"]"));
    }

    public boolean intro3() {
        return
                isDisplayed(AppiumBy.xpath("//android.view.View[@content-desc=\"Next\"]"));
    }

    public void clickNextButton() {
        click((AppiumBy.xpath("//android.view.View[@content-desc=\"Next\"]")));
    }

    public void clickSignInMenu() {
        click(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Masuk\"]"));

    }

    public void RegisterButton() {
        click(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Register\"]"));

    }

    public void swipe1() {
        swipeLeft();
    }

    public void swipe2() {
        swipeLeft();
    }
}