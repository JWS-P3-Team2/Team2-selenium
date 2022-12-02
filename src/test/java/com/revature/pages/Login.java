package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    public Login(WebDriver driver) {

        PageFactory.initElements(driver,this);
    }

    @FindBy(id="email")
    public WebElement email;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(xpath="//form//button")
    public WebElement loginButton;



}
