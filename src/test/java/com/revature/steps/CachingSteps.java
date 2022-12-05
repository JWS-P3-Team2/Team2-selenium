package com.revature.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public abstract class CachingSteps {

    String homeUrl = "http://localhost:4200";
    String loginUrl = "http://localhost:4200/login";
    String profileUrl = "http://localhost:4200/userProfile";
    WebDriver driver;
    WebDriverWait wait;
    Map<String, Object> cache;

}
