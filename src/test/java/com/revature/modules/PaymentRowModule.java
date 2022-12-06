package com.revature.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PaymentRowModule {

    @CacheLookup
    @FindBy(xpath="td[1]")
    public WebElement cardNumberTd;

    @CacheLookup
    @FindBy(xpath="td[2]")
    public WebElement expDateTd;

    @CacheLookup
    @FindBy(xpath="td[3]")
    public WebElement ccvTd;

    @CacheLookup
    @FindBy(xpath="td[4]")
    public WebElement actionTd;

    @CacheLookup
    @FindBy(xpath="td[4]/button[text()='DELETE']")
    public WebElement deleteButton;

}
