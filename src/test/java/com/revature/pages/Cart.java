package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {
    public Cart(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(className="sc-iqcoie")
    public WebElement productDiv;

    @FindBy(xpath="//button[text()='+']")
    public WebElement addButton;

    @FindBy(xpath="//button[text()='-']")
    public WebElement subtractButton;

    @FindBy(xpath="//*[@id='root']/div[2]/div/div[2]/div[1]/div[1]/div[2]/div[2]/button[2]")
    public WebElement trashButton;

    @FindBy(className="sc-fnykZs")
    public WebElement firstProductNumber;

    @FindBy(className="sc-hHLeRK")
    public WebElement firstProductAmount;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[2]/div[3]")
    public WebElement cartLink;
}
