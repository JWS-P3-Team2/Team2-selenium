package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
    public Home(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//strong[text()='SIGN IN']")
    public WebElement signInLink;

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

}
