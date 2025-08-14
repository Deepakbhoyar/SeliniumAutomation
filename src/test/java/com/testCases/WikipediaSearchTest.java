package com.testCases;

import com.baseTestCase.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.pages.WikipediaHomePage;
import com.utilities.Logging;
import com.utilities.Screenshot;

import java.time.Duration;

public class WikipediaSearchTest extends BaseTest {

    @Test
    public void wikipediaSearchTest() {
        driver.manage().window().maximize();
        Logging.info("Navigated to Wikipedia homepage");
        Screenshot.takeScreenshot(driver, "HomePage");

        WikipediaHomePage wikiHome = new WikipediaHomePage(driver);

        Logging.info("Entering search term 'Selenium'");
        wikiHome.enterSearchTerm("Selenium");
        wikiHome.clickSearch();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Selenium"));

        Logging.info("Validating page title contains 'Selenium'");
        String title = wikiHome.getPageTitle();
        Logging.info("Page title: " + title);
        Assert.assertTrue(title.contains("Selenium"), "Search did not land on Selenium page!");

        Screenshot.takeScreenshot(driver, "SearchResult");
    }

}