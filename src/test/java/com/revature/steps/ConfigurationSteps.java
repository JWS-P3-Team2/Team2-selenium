package com.revature.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfigurationSteps extends SeleniumSteps {

    @BeforeAll
    public static void initialize() {
        WebDriverManager.chromedriver().setup();
    }

    @Before("@selenium")
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    @After("@selenium")
    public void cleanup() {
        driver.quit();
        cache.clear();
    }
}
