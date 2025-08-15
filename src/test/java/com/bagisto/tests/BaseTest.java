package com.bagisto.tests;

import com.bagisto.utils.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {

    WebDriver driver;

    @Parameters("browser")
    @BeforeSuite
    public void setUp(@Optional("chrome") String browser) {

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }


        driver.navigate().to("https://demo.bagisto.com/bagisto-common");
        driver.manage().window().maximize();
    }

    // Take screenshot when test cases fail and add it in the Screenshots folder
    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot...");
            Helper.takeScreenshot(driver, result.getName());
        }
    }

    @AfterSuite
    public void tearDownSuite() {
        driver.quit();
    }
}
