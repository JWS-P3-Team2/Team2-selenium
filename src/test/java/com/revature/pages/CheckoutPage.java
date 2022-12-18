package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage {
    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstNameInput;
    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastNameInput;
    @FindBy(xpath = "//input[@id='address1']")
    public WebElement addressInput;
    @FindBy(xpath = "//input[@id='city']")
    public WebElement cityInput;
    @FindBy(xpath = "//input[@id='state']")
    public WebElement stateInput;
    @FindBy(xpath = "//input[@id='zip']")
    public WebElement zipInput;
    @FindBy(xpath = "//input[@id='country']")
    public WebElement countryInput;
    @FindBy(xpath = "//body/div[@id='root']/main[1]/div[1]/form[1]/div[2]/button[1]")
    public WebElement nextBtn;
    @FindBy(xpath = "//input[@class='PrivateSwitchBase-input css-1m9pwf3']")
    public WebElement paymentOptCheckbox;
    @FindBy(xpath = "//body/div[@id='root']/main[1]/div[1]/form[1]/div[1]/button[1]")
    public WebElement submitPaymentBtn;
    @FindBy(xpath = "//body/div[@id='root']/main[1]/div[1]/div[3]/button[2]")
    public WebElement placeOrderBtn;
    @FindBy(xpath = "//h6")
    public WebElement notificationMessage;

    @FindBy(xpath = "//p[@id='firstName-helper-text']")
    public List<WebElement> firstNameInputToolTip;
    @FindBy(xpath = "//p[@id='lastName-helper-text']")
    public List<WebElement> lastNameInputInputToolTip;
    @FindBy(xpath = "//p[@id='address1-helper-text']")
    public List<WebElement> addressInputInputToolTip;
    @FindBy(xpath = "//p[@id='city-helper-text']")
    public List<WebElement> cityInputInputToolTip;
    @FindBy(xpath = "//p[@id='state-helper-text']")
    public List<WebElement> stateInputInputToolTip;
    @FindBy(xpath = "//p[@id='zip-helper-text']")
    public List<WebElement> zipInputInputToolTip;
    @FindBy(xpath = "//p[@id='country-helper-text']")
    public List<WebElement> countryInputInputToolTip;
}
