package com.revature.pages;

import com.revature.modules.DeactivateAccountModule;
import com.revature.modules.PaymentManagementModule;
import com.revature.modules.PaymentRowModule;
import com.revature.modules.UpdateProfileModule;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    @CacheLookup
    @FindBy(xpath="/html/body/div[@id='root']/main[1]/div")
    public WebElement updateProfile;
    public UpdateProfileModule getUpdateProfile() {
        return PageFactory.initElements(
            updateProfile,
            UpdateProfileModule.class
        );
    }

    @CacheLookup
    @FindBy(xpath="/html/body/div[@id='root']/div[3]/div")
    public WebElement deactivateAccount;
    public DeactivateAccountModule getDeactivateAccount() {
        return PageFactory.initElements(
                deactivateAccount,
                DeactivateAccountModule.class
        );
    }

    @CacheLookup
    @FindBy(xpath="/html/body/div/main[2]/div")
    public WebElement paymentManagement;
    public PaymentManagementModule getPaymentManagement() {
        return PageFactory.initElements(
                paymentManagement,
                PaymentManagementModule.class
        );
    }

}
