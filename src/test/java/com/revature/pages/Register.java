package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Register {
    public Register(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

}
