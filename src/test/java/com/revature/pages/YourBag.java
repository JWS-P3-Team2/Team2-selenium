package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourBag {
    public YourBag(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[2]/div[2]/button[1]")
    public WebElement checkoutNowBtn;
}
