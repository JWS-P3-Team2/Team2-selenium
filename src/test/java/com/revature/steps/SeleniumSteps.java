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
    protected static CartPage cartPage;
    protected static CheckoutPage checkoutPage;
    protected static HomePage homePage;
    protected static LoginPage loginPage;
    protected static OrdersPage ordersPage;
    protected static ProfilePage profilePage;
    protected static RegisterPage registerPage;
    protected static ReviewPage reviewPage;
}
