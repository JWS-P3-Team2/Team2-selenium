package com.revature.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PaymentManagementModule {

    @CacheLookup
    @FindBy(name="cardNumber")
    public WebElement cardNumberInput;

    @CacheLookup
    @FindBy(name="expDate")
    public WebElement expDateInput;

    @CacheLookup
    @FindBy(name="ccv")
    public WebElement ccvInput;

    @CacheLookup
    @FindBy(xpath="//button[text()='Add Payment']")
    public WebElement addPaymentButton;

    @CacheLookup
    @FindBy(tagName="table")
    public WebElement paymentTable;

}
