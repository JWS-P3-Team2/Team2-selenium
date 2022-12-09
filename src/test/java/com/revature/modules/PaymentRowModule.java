package com.revature.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PaymentRowModule extends RowModule {
    @CacheLookup
    @FindBy(xpath=".//button[text()='DELETE']")
    public WebElement deleteButton;

}
