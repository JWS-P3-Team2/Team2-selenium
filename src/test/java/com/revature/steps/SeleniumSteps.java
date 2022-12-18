package com.revature.steps;

import com.revature.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public abstract class SeleniumSteps {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Map<String, Object> cache = new HashMap<>();
    protected static EditProductsPage editProductsPage;
    protected static EditProductPage editProductPage;
    protected static CreateProductPage createProductPage;
    protected static Cart cartPage;
    protected static Checkout checkoutPage;
    protected static Home homePage;
    protected static Login loginPage;
    protected static Orders ordersPage;
    protected static Profile profile;
    protected static ProfilePage profilePage;
    protected static Register registerPage;
    protected static Review reviewPage;
    protected static YourBag yourBagPage;

}
