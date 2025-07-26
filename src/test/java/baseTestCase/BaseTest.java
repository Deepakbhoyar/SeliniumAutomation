package baseTestCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utilities.Logging;
import utilities.Screenshot;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public static Properties pr = new Properties();

    @BeforeTest
    public void setup() throws IOException {
        Logging.info("Loading configuration...");
        if (driver == null) {
            FileReader fr = new FileReader("src/test/resources/configfiles/config.properties");
            pr.load(fr);
        }

        String browser = pr.getProperty("browser");
        String testLink = pr.getProperty("testlink");
        Logging.info("Initializing " + browser + " driver...");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driver.get(testLink);
        Logging.info("Navigated to: " + testLink);
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            Screenshot.takeScreenshot(driver, "Teardown");
            driver.quit();
            Logging.info("Browser closed. Tear down done.");
        }
    }
}