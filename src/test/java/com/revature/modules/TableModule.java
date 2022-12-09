package com.revature.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<RowModule> getRows() {
        return rows.stream().map(row -> {
            return PageFactory.initElements(
                    row,
                    RowModule.class
            );
        }).collect(Collectors.toList());
    }

}
