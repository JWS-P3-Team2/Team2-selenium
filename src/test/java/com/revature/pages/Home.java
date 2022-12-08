package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Home {

    @FindBy(xpath="//strong[text()='SIGN IN']")
    public WebElement signInLink;

    @FindBy(xpath="//strong[text()='ORDERS']")
    public WebElement orderLink;

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

    @FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[1]/input[1]")
    public WebElement searchInput;

    @FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/button[1]")
    public WebElement searchButton;

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/h5[1]")
    public WebElement searchResultHeader;

    @FindBy(xpath="//strong[text()='ORDERS']")
    public WebElement ordersLink;

    @FindBy(xpath="//*[@class='MuiSwitch-root']")
    public WebElement darkModeBtn;

    @FindBy(tagName = "Body")
    public WebElement mainBody;
    
    public Home(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
}
