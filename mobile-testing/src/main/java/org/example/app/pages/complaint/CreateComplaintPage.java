package org.example.app.pages.complaint;

import io.appium.java_client.AppiumBy;
import org.example.app.base.BasePageObject;

public class CreateComplaintPage extends BasePageObject {
    public boolean getCreateComplaintTitle() {
        return
                isDisplayed(AppiumBy.xpath("//android.view.View[@content-desc=\"Buat Keluhan\"]"));
    }

    public void inputComplaintField(String complaint) {
        type(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]"), complaint);
    }

    public void clickAttachIcon() {
        click(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button[1]"));
    }

    public void chooseImageMenu() {
        click(AppiumBy.xpath("//android.view.View[@content-desc=\"Pilih Gambar\"]"));
    }

    public void chooseImage() {
        click(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Foto diambil pada 11 Des 2023 1.57.12 PM\"]/androidx.cardview.widget.CardView/android.widget.FrameLayout/android.widget.ImageView"));
    }


    public void chooseVideoMenu() {
        click(AppiumBy.xpath("//android.view.View[@content-desc=\"Pilih Video\"]"));
    }

    public void inputAddress(String address) {
        type(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]"), address);
    }

    public void clickCategoryIcon() {
        click(AppiumBy.xpath("//android.view.View[@content-desc=\"Infrastruktur\"]"));
    }

    public void chooseCategory() {
        click(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Keamanan\"]"));
    }

    public void clickPostButton() {
        click(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Posting\"]"));
    }


}
