package com.revature.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentManagementModule extends FormModule {

    // cardNumber
    // expDate
    // ccv

    @CacheLookup
    @FindBy(xpath="//button[text()='Add Payment']")
    public WebElement submit;

    @CacheLookup
    @FindBy(tagName="table")
    public WebElement paymentTable;
    public PaymentTableModule getPaymentTable() {
        return PageFactory.initElements(
                paymentTable,
                PaymentTableModule.class
        );
    }

}
