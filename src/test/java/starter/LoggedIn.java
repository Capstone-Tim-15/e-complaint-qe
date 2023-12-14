package starter;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import starter.pages.DashboardPage;
import starter.pages.HomePage;
import starter.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoggedIn {
    @Steps
    HomePage homePage;

    @Steps
    LoginPage loginPage;

    @Steps
    DashboardPage dashboardPage;

    @Given("I've been logged in")
    public void verifyLoggedIn() {
        // Logout jika sudah login sebelumnya
        if (dashboardPage.isLogoutMenuVisible()) {
            dashboardPage.clickLogoutMenu();
            dashboardPage.clickLogoutButton();
        }

        // Buka halaman utama
        homePage.openUrl("https://gov-complaint-fe.vercel.app/");
        Assertions.assertTrue(homePage.validateOnHomePage());

        // Klik menu login
        homePage.clickLoginMenu();
        Assertions.assertTrue(loginPage.validateOnLoginPage());

        // Input username dan password
        loginPage.inputUsername("anggun");
        loginPage.inputPassword("1234567890");
        loginPage.clickLoginButton();

        // Waiting
        waitFor(1000);

        // Scroll ke atas menggunakan JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) homePage.getDriver();
        js.executeScript("window.scrollTo(0, 0);");

        // Tunggu sebentar setelah menggulir ke atas
        waitFor(1000);

        // Validate di dashboard (contoh validasi dengan mengecek visibilitas elemen notifikasi)
        Assertions.assertTrue(dashboardPage.validateOnDashboard());
    }

    // Metode untuk menunggu (mengatasi InterruptedException)
    private void waitFor(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
