package com.revature.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ProfilePage {

    @CacheLookup
    @FindBy(xpath="//h5[contains(text(),'Update Your Profile')]/parent::div/parent::div")
    public WebElement updateProfile;

    @CacheLookup
    @FindBy(xpath="//h5[contains(text(),'Deactivate Your Account')]/parent::form/parent::div")
    public WebElement deactivateAccount;

    @CacheLookup
    @FindBy(xpath="//h5[contains(text(),'Manage Your Payment')]/parent::div/parent::div")
    public WebElement paymentManagement;

}
