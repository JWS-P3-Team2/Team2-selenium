package com.revature.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RowModule {

    @CacheLookup
    @FindBy(xpath = "td")
    public List<WebElement> data;

}
