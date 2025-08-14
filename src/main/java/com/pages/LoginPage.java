package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "username")
    WebElement username ;

    @FindBy(id = "password")
    WebElement password ;

    @FindBy(id = "login")
    WebElement login ;

    public LoginPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void page (String user, String pass){
        username.sendKeys(user);
        password.sendKeys(pass);
        login.click();
    }


}
