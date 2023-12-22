package org.example.app.pages.auth;

import io.appium.java_client.AppiumBy;
import org.example.app.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage extends BasePageObject {
    public String getSignInButton() {
        try {
            By locator = AppiumBy.xpath("//android.widget.Button[@content-desc=\"Masuk\"]");
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return element.getAttribute("content-desc");
        } catch (Exception e) {
            // Handle exception, log it, or rethrow it
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
            throw new RuntimeException("Failed to get sign in button: " + e.getMessage());
        }
    }

    public void inputUsername(String username) {
        type(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]"), username);
    }

    public void inputPassword(String password) {
        type(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]"), password);
    }

    public void clickRememberMe() {
        click(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.CheckBox"));
    }

    public void clickSignInButton() {
        click(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Masuk\"]"));
    }

    public void emptyUsnErrMssg() {
        getText(AppiumBy.xpath("//android.view.View[@content-desc=\"username harus diisi\"]"));
    }

    public void emptyPsswdErrMssg() {
        getText(AppiumBy.xpath("//android.view.View[@content-desc=\"Password harus diisi\"]"));
    }
}
