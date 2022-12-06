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

    @FindBy(xpath="//h4[contains(text(),'Leave a Review')]")
    public WebElement productModal;

    @FindBy(xpath = "//input[@id=':ra:']")
    public WebElement fiveStarRating;

    @FindBy(xpath = "//body/div[3]/div[3]/div[1]/div[5]/span[1]/label[4]")
    public WebElement fourStarRating;

    @FindBy(xpath = "//body/div[3]/div[3]/div[1]/div[5]/span[1]/label[3]")
    public WebElement threeStarRating;

    @FindBy(xpath = "//body/div[3]/div[3]/div[1]/div[5]/span[1]/label[2]")
    public WebElement twoStarRating;

    @FindBy(xpath = "//body/div[3]/div[3]/div[1]/div[5]/span[1]/label[1]")
    public WebElement oneStarRating;

    @FindBy(xpath = "//textarea[@id='outlined-multiline-flexible']")
    public WebElement reviewTextArea;

    @FindBy(xpath = "//body/div[3]/div[3]/div[1]/div[5]/div[2]/button[1]")
    public WebElement submitReviewButton;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[3]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/p[3]")
    public WebElement reviewText;

    @FindBy(css = "div.MuiDialog-root.MuiModal-root.css-74waha:nth-child(4) div.MuiDialog-container.MuiDialog-scrollBody.css-oxi3kn:nth-child(3) div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation24.MuiDialog-paper.MuiDialog-paperScrollBody.MuiDialog-paperWidthSm.css-ufhb4j h2.MuiTypography-root.MuiTypography-h6.MuiDialogTitle-root.css-ryi2t6:nth-child(1) > button.MuiButtonBase-root.MuiIconButton-root.MuiIconButton-sizeMedium.css-1bp5i8m:nth-child(1)")
    public WebElement productPageOpenButton;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[3]/h1[1]")
    public WebElement productPageHeader;
    public Review(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
}
