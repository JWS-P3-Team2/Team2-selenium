package com.revature.steps.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public abstract class SeleniumSteps {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Map<String, Object> cache = new HashMap<>();
}
