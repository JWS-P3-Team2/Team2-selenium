package com.revature;

import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.revature.steps"
)
@RunWith(Cucumber.class)
public class MainRunner {




}
