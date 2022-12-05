package com.revature;

import com.revature.steps.CachingSteps;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.HashMap;

@CucumberOptions(
        features="src/test/resources/features",
        glue="com.revature.steps",
        tags="@user-profile"
)
public class CachingRunner extends AbstractTestNGCucumberTests {
    @BeforeSuite
    public static void cachingInitialize() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    public void cachingSetup() {
        CachingSteps.cache = new HashMap<>();
        CachingSteps.driver = new ChromeDriver();
        CachingSteps.wait = new WebDriverWait(
                CachingSteps.driver,
                Duration.ofSeconds(1)
        );
    }

    @AfterTest
    public void cachingCleanup() {
        CachingSteps.cache.clear();
        CachingSteps.driver.quit();
    }

}
