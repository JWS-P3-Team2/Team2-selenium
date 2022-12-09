package com.revature.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DeactivateAccountModule extends FormModule {

    // Deactivate

    @CacheLookup
    @FindBy(xpath=".//button[text()='Deactivate']")
    public WebElement submit;

}
