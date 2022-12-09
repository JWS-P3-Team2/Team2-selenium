package com.revature.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public abstract class SeleniumSteps {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Map<String, Object> cache = new HashMap<>();
    protected static String profileUrl = "http://localhost:4200/userProfile";
    protected static String loginUrl = "http://localhost:4200/login";
    protected static String homeUrl = "http://localhost:4200";
}
