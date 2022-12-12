package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Review {

    @FindBy(xpath="//body/div[@id='root']/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/*[1]")
    public WebElement firstProductDetailsButton;

    @FindBy(xpath="//body/div[@id='root']/div[3]/div[1]/div[1]")
    public WebElement firstProductCard;

    @FindBy(xpath="//body/div[@id='root']/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/*[1]")
    public WebElement secondProductDetailsButton;

    @FindBy(xpath="//h4[contains(text(),'Leave a Review')]")
    public WebElement productModal;

    @FindBy(className = "css-ykqdxu")
    public WebElement fiveStarRating;


    @FindBy(xpath = "//textarea[@id='outlined-multiline-flexible']")
    public WebElement reviewTextArea;


    @FindBy(className = "css-1hw9j7s")
    public WebElement submitReviewButton;


    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/p[3]")
    public WebElement reviewText;

    @FindBy(xpath = "//p[contains(text(),'This is a review')]")
    public WebElement reviewTextModal;

    @FindBy(className = "css-o6fw7o")
    public WebElement productPageOpenButton;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[3]/h1[1]")
    public WebElement productPageHeader;

    @FindBy(xpath = "//p[contains(text(),'No reviews..')]")
    public WebElement noReviewsText;

    @FindBy(className = "css-1lpukdo")
    public WebElement productModalDeleteButton;
    public Review(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
}
