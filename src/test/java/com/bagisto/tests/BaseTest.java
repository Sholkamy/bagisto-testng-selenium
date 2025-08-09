package com.bagisto.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

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

    @AfterSuite
    public void tearDownSuite() {
        driver.quit();
    }
}
