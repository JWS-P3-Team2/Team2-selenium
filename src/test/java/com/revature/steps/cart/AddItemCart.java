package com.revature.steps.cart;

import com.revature.MainRunner;
import com.revature.pages.Home;
import com.revature.pages.Login;
import com.revature.steps.SeleniumSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AddItemCart extends SeleniumSteps {
    private static Home homePage = new Home(driver);
    private static Login loginPage = new Login(driver);

    @Given("The user is on the home page")
    public void the_user_is_on_the_home_page() {
        driver.get("http://localhost:4200/");
    }
    @When("The user hovers over a product window")
    public void the_user_hovers_over_a_product_window() {
        Actions action = new Actions(driver);
        WebElement firstProduct = wait.until(ExpectedConditions.visibilityOf(homePage.firstProduct));
        action.moveToElement(firstProduct).perform();
    }
    @When("The user clicks the cart icon in the product window")
    public void the_user_clicks_the_cart_icon_in_the_product_window() {
        WebElement cartLink = driver.findElement(By.xpath("//body/div[@id='root']/div[3]/div[1]/div[1]/div[1]/div[1]"));
        cartLink.click();
    }
    @Then("The product should be added to the cart")
    public void the_product_should_be_added_to_the_cart() {
        WebElement cart = homePage.navCartLink;
        cart.click();
        WebElement product1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='root']/div[2]/div[1]/div[2]/div[1]/div[1]")));
        Assert.assertTrue(product1.isDisplayed());
    }
    @When("The user hovers over a different product window")
    public void the_user_hovers_over_a_different_product_window() {
        Actions action = new Actions(driver);
        WebElement secondProduct = wait.until(ExpectedConditions.visibilityOf(homePage.secondProduct));
        action.moveToElement(secondProduct).perform();
    }
    @When("The user clicks the cart icon in the second product window")
    public void the_user_clicks_the_cart_icon_in_the_second_product_window() {
        WebElement cartLink = driver.findElement(By.xpath("//body/div[@id='root']/div[3]/div[2]/div[1]/div[1]/div[1]"));
        cartLink.click();
    }
    @Then("Both products should be added to the cart")
    public void both_products_should_be_added_to_the_cart() {
        WebElement cart = homePage.navCartLink;
        cart.click();
        WebElement product1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='root']/div[2]/div[1]/div[2]/div[1]/div[1]")));
        WebElement product2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='root']/div[2]/div[1]/div[2]/div[1]/div[2]")));
        Assert.assertTrue(product1.isDisplayed());
        Assert.assertTrue(product2.isDisplayed());
    }
    @Given("The registered user is on the home page")
    public void the_registered_user_is_on_the_home_page() {
        driver.get("http://localhost:4200/");
        wait.until(ExpectedConditions.visibilityOf(homePage.signInLink));
        homePage.signInLink.click();
        wait.until(ExpectedConditions.visibilityOf(loginPage.email));
        loginPage.email.sendKeys("test@example.com");
        wait.until(ExpectedConditions.visibilityOf(loginPage.password));
        loginPage.password.sendKeys("guest");
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginButton));
        loginPage.loginButton.click();
    }
    @When("The registered user hovers over a product window")
    public void the_registered_user_hovers_over_a_product_window() {
        Actions action = new Actions(driver);
        WebElement firstProduct = wait.until(ExpectedConditions.visibilityOf(homePage.firstProduct));
        action.moveToElement(firstProduct).perform();
    }
    @When("The registered user clicks the cart icon in the product window")
    public void the_registered_user_clicks_the_cart_icon_in_the_product_window() {
        WebElement cartLink = driver.findElement(By.xpath("//body/div[@id='root']/div[3]/div[1]/div[1]/div[1]/div[1]"));
        cartLink.click();
    }
    @When("The registered user hovers over a different product window")
    public void the_registered_user_hovers_over_a_different_product_window() {
        Actions action = new Actions(driver);
        WebElement secondProduct = wait.until(ExpectedConditions.visibilityOf(homePage.secondProduct));
        action.moveToElement(secondProduct).perform();
    }
    @When("The registered user clicks the cart icon in the second product window")
    public void the_registered_user_clicks_the_cart_icon_in_the_second_product_window() {
        WebElement cartLink = driver.findElement(By.xpath("//body/div[@id='root']/div[3]/div[2]/div[1]/div[1]/div[1]"));
        cartLink.click();
    }
}