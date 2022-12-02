package com.revature.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Profile {
    @FindBy(xpath="//h2[1]/")
    public WebElement profileGreeting;
}
