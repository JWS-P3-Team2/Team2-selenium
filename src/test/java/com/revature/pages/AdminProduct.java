package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminProduct {
    public AdminProduct(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//div[2]/div/div/button")
    public WebElement createNew;

    @FindBy(xpath="//*/div[2]/div/div/div[1]/button")
    public WebElement backToProduct;

    @FindBy(xpath="//*/div[3]/div/button")
    public WebElement products;

    @FindBy(xpath="//*[contains(@class, 'MuiInputBase-input MuiOutlinedInput-input css-h4os0j')]")
    public WebElement[] productInputs;

    @FindBy(xpath="//button[contains(text(),'Update')]")
    public WebElement updateProduct;

    @FindBy(xpath="//*/div[3]/div/button/div/div/div/h5")
    public WebElement[] productNames;
    @FindBy(xpath="//*/div[3]/div/button/div/p")
    public WebElement[] productDescriptions;
    @FindBy(xpath="//*/div[3]/div/button/div/div/div/div/h6")
    public WebElement[] productPrices;
    @FindBy(xpath="//*/div[3]/div/button/img")
    public WebElement[] productImages;
}
