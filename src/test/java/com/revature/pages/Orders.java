package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Orders {

    public Orders(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//div[contains(@class,'css-1qw96cp')]/a")
    public WebElement firstOrder;
    @FindBy(xpath="//div[contains(@class,'css-1qw96cp')]/a")
    public List<WebElement> previousOrders;

}
