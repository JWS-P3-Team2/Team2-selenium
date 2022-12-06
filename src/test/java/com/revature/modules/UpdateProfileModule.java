package com.revature.modules.profile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class UpdateProfileModule {

    @CacheLookup
    @FindBy(name="firstName")
    public WebElement firstNameInput;

    @CacheLookup
    @FindBy(name="lastName")
    public WebElement lastNameInput;

    @CacheLookup
    @FindBy(name="password")
    public WebElement passwordInput;

    @CacheLookup
    @FindBy(xpath="//button[text()='Update']")
    public WebElement updateButton;
}
