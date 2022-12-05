package com.revature;

import com.revature.pages.Home;
import com.revature.pages.Login;
import com.revature.pages.Profile;
import com.revature.pages.Register;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

@CucumberOptions(
        features="src/test/resources/features",
        glue="com.revature.steps"
)
public class MainRunner extends AbstractTestNGCucumberTests {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static String webURL = "http://localhost:4200";

    public static Home homePage;
    public static Login loginPage;
    public static Register registerPage;

    public static Profile profilePage;

    @BeforeMethod
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        homePage = new Home(driver);
        loginPage = new Login(driver);
        registerPage = new Register(driver);
        profilePage = new Profile(driver);
    }

    @AfterMethod
    public void cleanup() { driver.quit(); }
}
