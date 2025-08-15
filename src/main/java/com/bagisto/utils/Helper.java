package com.bagisto.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    public static void takeScreenshot(WebDriver driver, String testName) {

        // Time format for the file name to be Unique
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

        // Specify the path to the Screenshots folder within the project
        String screenshotDir = System.getProperty("user.dir") + "/Screenshots/";

        // Take a screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            String filePath = screenshotDir + testName + "_" + timestamp + ".png";
            FileUtils.copyFile(srcFile, new File(filePath));
            System.out.println("✅ Screenshot saved at: " + filePath);
        } catch (IOException e) {
            System.out.println("❌ Failed to save screenshot: " + e.getMessage());
        }
    }
}
