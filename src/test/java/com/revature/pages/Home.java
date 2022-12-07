package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Home {

    @FindBy(xpath="//strong[text()='SIGN IN']")
    public WebElement signInLink;

    @FindBy(xpath="//*[@id='customized-dialog-title']/button[2]")
    public WebElement productModalCloseButton;

    @FindBy(xpath="//body/div[@id='root']/div[3]/div")
    public List<WebElement> allProducts;

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


    @FindBy(xpath="//strong[text()='EDIT PRODUCTS']")
    public WebElement editProductLink;
//    @FindBy(xpath="//div[3]/div[1]/div")
//    public WebElement firstProduct;

    @FindBy(xpath="//*[@class='MuiSwitch-root']")
    public WebElement darkModeBtn;

    @FindBy(tagName = "Body")
    public WebElement mainBody;
    
    public Home(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

}
