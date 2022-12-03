package com.revature.pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register {
    public Register(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="firstName")
    public WebElement firstName;

    @FindBy(id="lastName")
    public WebElement lastName;

    @FindBy(id="email")
    public WebElement email;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(xpath="//form//button")
    public WebElement loginButton;

}
