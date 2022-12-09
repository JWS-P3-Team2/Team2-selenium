package com.revature.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TableModule {

    @CacheLookup
    @FindBy(tagName="thead")
    public WebElement thead;

    @FindBy(xpath="//thead/th")
    public List<WebElement> headers;

    @CacheLookup
    @FindBy(tagName="tbody")
    public WebElement tbody;

    @FindBy(xpath="//tbody/tr")
    public List<WebElement> rows;

}
