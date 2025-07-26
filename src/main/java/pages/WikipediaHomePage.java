package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikipediaHomePage {

    private WebDriver driver;

    // Locators
    private By searchBox = By.id("searchInput");
    private By searchButton = By.xpath("//button[@type='submit']");

    // Constructor
    public WikipediaHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterSearchTerm(String term) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(term);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}

