package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
    public Home(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//strong[text()='SIGN IN']")
    public WebElement signInLink;

    @FindBy(xpath="//strong[text()='PROFILE']")
    public WebElement profileLink;

}
