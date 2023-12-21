package org.example.app.base;

import io.appium.java_client.touch.WaitOptions;
import org.example.app.drivers.AndroidDriverInit;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import java.time.Duration;

    public class BasePageObject {
        public AndroidDriver getDriver() {
            if (AndroidDriverInit.driver == null) {
                AndroidDriverInit.initialize();
            }
            return AndroidDriverInit.driver;
        }

        public WebElement find(By by) {
            try {
                WebElement element = getDriver().findElement(by);
                return element;
            } catch (NoSuchElementException e) {
                // Handle exception (log, throw custom exception, etc.)
                // Contoh:
                e.printStackTrace();
                throw new RuntimeException("Element with locator " + by + " not found.", e);
            }
        }

        public void type(By by, String text) {
            WebElement element = find(by);
            element.clear();
            element.sendKeys(text);
        }

        public void click(By by) {
            find(by).click();
        }

        public String getText(By by) {
            return find(by).getText();
        }

        public boolean isDisplayed(By by) {
            return find(by).isDisplayed();
        }

        public void swipeLeft() {
            // Dapatkan ukuran layar
            int screenWidth = getDriver().manage().window().getSize().getWidth();
            int screenHeight = getDriver().manage().window().getSize().getHeight();

            // Tentukan titik awal dan akhir untuk swipe
            int startX = (int) (screenWidth * 0.8); // 80% dari sisi kanan layar
            int endX = (int) (screenWidth * 0.2); // 20% dari sisi kiri layar
            int centerY = screenHeight / 2;

            // Lakukan swipe ke kiri
            TouchAction touchAction = new TouchAction(getDriver());
            touchAction.press(PointOption.point(startX, centerY))
                    //.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))) // Tunggu 1 detik
                    .moveTo(PointOption.point(endX, centerY))
                    .release()
                    .perform();
        }
    }

