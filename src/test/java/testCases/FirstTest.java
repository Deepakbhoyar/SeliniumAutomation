package testCases;

import baseTestCase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Logging;
import utilities.Screenshot;

public class FirstTest extends BaseTest {

    @Test
    public void wikipediaSearchTest() throws InterruptedException {
        driver.manage().window().maximize();
        Logging.info("Navigated to Wikipedia homepage");
        Screenshot.takeScreenshot(driver, "HomePage");

        Logging.info("Entering search term 'Selenium'");
        driver.findElement(By.id("searchInput")).sendKeys("Selenium");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);

        Logging.info("Validating page title contains 'Selenium'");
        String title = driver.getTitle();
        Logging.info("Page title: " + title);
        Assert.assertTrue(title.contains("Selenium"), "Search did not land on Selenium page!");

        Screenshot.takeScreenshot(driver, "SearchResult");

        // You can add more steps, e.g. click links, validate text, etc.
    }
}