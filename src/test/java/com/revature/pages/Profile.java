package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Profile {
    public Profile(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//h2[1]/")
    public WebElement profileGreeting;
}
