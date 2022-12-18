package com.revature.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfigSteps extends SeleniumSteps {

    private static String browser = System.getProperty("CUCUMBER_BROWSER");
    @BeforeAll
    public static void initialize() {
        if (browser == null) {
            WebDriverManager.chromedriver().setup();
        }
        else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
        }
        else if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
        }
        else {
            throw new Error("unrecognized browser");
        }
    }

    @Before
    public void setup() {
        if (browser == null) {
            driver = new ChromeDriver();
        }
        else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        else if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        }
        else {
            throw new Error("unrecognized browser");
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    @After
    public void cleanup() {
        driver.quit();
        cache.clear();
    }
}
