package testCases;

import baseTestCase.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class FirstTest extends BaseTest {

    @Test
    public void logintext() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Sign In")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='login_id']")).sendKeys("deepakbhoyar1998@gmail.com");
        driver.findElement(By.xpath("//button[@id='nextbtn']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Deepak@#1998");
        driver.findElement(By.xpath("//button[@id='nextbtn']")).click();
    }

}
