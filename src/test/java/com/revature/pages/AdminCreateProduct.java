package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminCreateProduct {
    public AdminCreateProduct(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//div[2]/div/div/button")
    public WebElement createNew;

    @FindBy(xpath="//*/div[3]/div/button")
    public WebElement products;

    @FindBy(xpath="//*/div[3]/div/button/div/div/div/h5")
    public List<WebElement> productNames;
    @FindBy(xpath="//*/div[3]/div/button/div/p")
    public List<WebElement> productDescriptions;
    @FindBy(xpath="//*/div[3]/div/button/div/div/div/div/h6")
    public List<WebElement> productPrices;
    @FindBy(xpath="//*/div[3]/div/button/img")
    public List<WebElement> productImages;
}
