package org.example.hooks;

import org.example.app.drivers.AndroidDriverInit;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AndroidDriverHook {

    @Before(value = "@android")
    public void beforeScenario() {
        AndroidDriverInit.initialize();
    }

    @After(value = "@android")
    public void afterScenario(Scenario scenario) {
        AndroidDriverInit.quit();
    }

    @BeforeStep
    public void beforeStep() {
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        try {
            TakesScreenshot screenshot = AndroidDriverInit.driver;
            byte[] imageByte = screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(imageByte, "image/png", scenario.getId());
        } catch (Exception e) {
            // Handle exception if screenshot capture fails
            e.printStackTrace();
        }
    }
}