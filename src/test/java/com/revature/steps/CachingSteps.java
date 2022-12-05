package com.revature.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public abstract class CachingSteps {

    public static String homeUrl = "http://localhost:4200";
    public static String loginUrl = "http://localhost:4200/login";
    public static String profileUrl = "http://localhost:4200/userProfile";
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Map<String, Object> cache;

}
