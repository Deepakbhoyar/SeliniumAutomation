package baseTestCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public static FileReader fr;
    public static Properties pr = new Properties();

    @BeforeTest
    public void setup() throws IOException {
        if (driver==null){
            FileReader fr = new FileReader("C:\\Users\\deepa\\IdeaProjects\\SeliniumAutomation\\src\\test\\resources\\configfiles\\config.properties");
            pr.load(fr);
        }

        if (pr.getProperty("browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(pr.getProperty("testlink"));
        }

        else if (pr.getProperty("browser").equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(pr.getProperty("testlink"));
        }
    }

    @AfterTest
    public void teardown() {
        driver.close();
        System.out.println("The tear down is done");
    }
    
}
