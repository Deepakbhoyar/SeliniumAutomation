package testCases;

import baseTestCase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Logging;
import utilities.Screenshot;

public class FirstTest extends BaseTest {

    @Test
    public void logintext() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        driver.manage().window().maximize();

        Logging.info("Clicking on Sign In");
        driver.findElement(By.linkText("Sign In")).click();
        Thread.sleep(2000);

        Logging.info("Entering login ID");
        driver.findElement(By.xpath("//input[@id='login_id']")).sendKeys("deepakbhoyar1998@gmail.com");
        driver.findElement(By.xpath("//button[@id='nextbtn']")).click();
        Thread.sleep(2000);

        Logging.info("Entering password");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Deepak@#1998");
        driver.findElement(By.xpath("//button[@id='nextbtn']")).click();

        // Add screenshot after login
        Screenshot.takeScreenshot(driver, "AfterLogin");

        // Example: Navigate to dashboard/profile page, update the locator as needed
        Logging.info("Navigating to Dashboard");
        Thread.sleep(3000); // Wait for page to load
        driver.findElement(By.linkText("Dashboard")).click();
        Screenshot.takeScreenshot(driver, "DashboardPage");

        // Example: Validate welcome message
        Logging.info("Validating welcome message");
        Thread.sleep(2000);
        String welcomeText = driver.findElement(By.id("welcome-message")).getText();
        Logging.info("Welcome message: " + welcomeText);
        Assert.assertTrue(welcomeText.contains("Welcome"), "Welcome message not displayed!");

        Screenshot.takeScreenshot(driver, "WelcomeMessage");

        // You can keep adding more steps below as per your test flow...
        // For example, logout, navigate to another page, etc.
    }
}