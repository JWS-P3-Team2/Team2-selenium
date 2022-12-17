package com.revature.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class UpdateProfileModule extends FormModule {

    // firstName
    // lastName
    // password

    @CacheLookup
    @FindBy(xpath=".//button[text()='Update']")
    public WebElement submit;
}
