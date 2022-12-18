package com.revature.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EditProductPage {
    @FindBy(xpath="//input")
    public List<WebElement> productInputs;
    @FindBy(xpath="//button[contains(text(),'Update')]")
    public WebElement updateProduct;
    @FindBy(xpath="//button[contains(text(),'Back to Products')]")
    public WebElement backToProduct;
}
