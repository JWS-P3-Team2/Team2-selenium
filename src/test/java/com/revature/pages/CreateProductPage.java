package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreateProductPage {
    public CreateProductPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//div[2]/div/div/button")
    public WebElement createNew;

    @FindBy(xpath="//*/div[2]/div/div/div[1]/button")
    public WebElement backToProduct;

    @FindBy(xpath="//input")
    public List<WebElement> productInputs;

    @FindBy(xpath="//button[contains(text(),'Update')]")
    public WebElement updateProduct;


}
