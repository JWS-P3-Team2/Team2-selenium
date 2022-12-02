package com.revature.steps;

import com.revature.MainRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search {

    public static WebDriver driver;

    @Before
    public  void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        driver.quit();
    }
    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("localhost:4200");
        throw new io.cucumber.java.PendingException();
    }
}
