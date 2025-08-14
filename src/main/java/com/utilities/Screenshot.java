package com.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {
    public static void takeScreenshot(WebDriver driver, String name) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String path = "screenshots/" + name + "_" + timestamp + ".png";
        try {
            FileHandler.createDir(new File("screenshots"));
            FileHandler.copy(src, new File(path));
        } catch (IOException e) {
            Logging.error("Failed to save screenshot", e);
        }
    }
}