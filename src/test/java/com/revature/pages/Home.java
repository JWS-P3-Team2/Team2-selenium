package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {

    @FindBy(xpath="//strong[text()='SIGN IN']")
    public WebElement signInLink;

    @FindBy(xpath="//body/div[@id='root']/div[3]/div[1]")
    public WebElement firstProduct;

    @FindBy(xpath="//body/div[@id='root']/div[3]/div[2]")
    public WebElement secondProduct;

    @FindBy(xpath="//*[@class='MuiSvgIcon-root']")
    public WebElement navCartLink;

    @FindBy(xpath="//strong[text()='REGISTER']")
    public WebElement registerLink;

    @FindBy(xpath="//strong[text()='PROFILE']")
    public WebElement profileLink;
    
    public Home(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
}
