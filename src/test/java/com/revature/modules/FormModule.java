package com.revature.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FormModule {

    @CacheLookup
    @FindBy(xpath = "//*[@name]")
    public List<WebElement> fields;
    public WebElement get(String name) {
        for (WebElement field : fields) {
            if (field.getAttribute("name").equals(name)) {
                return field;
            }
        }
        throw new IllegalArgumentException(
                "name: " + name + " not found in fields"
        );
    }

    @CacheLookup
    @FindBy(css = "button[type='submit']")
    public WebElement submit;

}
