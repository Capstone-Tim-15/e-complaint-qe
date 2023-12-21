package org.example.app.pages.auth;

import org.example.app.base.BasePageObject;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends BasePageObject {
    public boolean validateOnRegisterPage() {
        try {
            By locator = AppiumBy.xpath("//android.widget.Button[@content-desc=\"Buat Akun\"]");
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return Boolean.parseBoolean(element.getAttribute("content-desc"));
        } catch (Exception e) {
            // Handle exception, log it, or rethrow it
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
            throw new RuntimeException("Failed to get register button: " + e.getMessage());
        }
    }

    public void clickRegisterButton() {
        click(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Buat Akun\"]"));
    }

    public void clickSignInMenu() {
        click(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Masuk Disini\"]"));
    }

    public void inputName(String name) {
        type(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]"), name);

    }

    public void inputPhone(String phone) {
        type(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]"), phone);

    }

    public void inputEmail(String email) {
        type(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[3]"), email);

    }

    public void inputUsername(String username) {
        type(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[4]"), username);

    }

    public void inputPassword(String password) {
        type(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[4]"), password);
    }

    public void inputConfirmPassword(String confirmPassword) {
        type(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[6]"), confirmPassword);
    }

    public void emptyNameErrorMessage() {
        getText(AppiumBy.xpath("//android.view.View[@content-desc=\"Nama tidak boleh kosong\"]"));
    }

    public void emptyPhoneErrorMessage() {
        getText(AppiumBy.xpath("//android.view.View[@content-desc=\"Nomor Telepon tidak boleh kosong\"]"));
    }

    public void emptyUsernameErrorMessage() {
        getText(AppiumBy.xpath("//android.view.View[@content-desc=\"Username tidak boleh kosong\"]"));
    }

    public void emptyEmailErrorMessage() {
        getText(AppiumBy.xpath("//android.view.View[@content-desc=\"Email tidak boleh kosong\"]"));
    }

    public void emptyPasswordErrorMessage() {
        getText(AppiumBy.xpath("//android.view.View[@content-desc=\"Kata Sandi tidak boleh kosong\"]"));
    }

}
