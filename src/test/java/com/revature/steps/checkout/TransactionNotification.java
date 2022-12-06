package com.revature.steps.checkout;

import com.revature.MainRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TransactionNotification {

    @Given("The user has added an item to their cart")
    public void the_user_has_added_an_item_to_their_cart() {
        MainRunner.driver.get("http://localhost:4200/");
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.signInLink));
        MainRunner.homePage.signInLink.click();
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.loginPage.email));
        MainRunner.loginPage.email.sendKeys("test@example.com");
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.loginPage.password));
        MainRunner.loginPage.password.sendKeys("guest");
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.loginPage.loginButton));
        MainRunner.loginPage.loginButton.click();
        Actions action = new Actions(MainRunner.driver);
        WebElement firstProduct = MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.firstProduct));
        action.moveToElement(firstProduct).perform();
        MainRunner.driver.findElement(By.xpath("//body/div[@id='root']/div[3]/div[1]/div[1]/div[1]/div[1]")).click();
        MainRunner.homePage.navCartLink.click();
    }
    @When("The user clicks the checkout button from the cart link")
    public void the_user_clicks_the_checkout_button_from_the_cart_link() {
        MainRunner.yourBagPage.checkoutNowBtn.click();
    }
    @When("The user fills out the shipping information")
    public void the_user_fills_out_the_shipping_information() {
        MainRunner.checkoutPage.firstNameInput.sendKeys("testfname");
        MainRunner.checkoutPage.lastNameInput.sendKeys("testlname");
        MainRunner.checkoutPage.addressInput.sendKeys("101 Test Lane");
        MainRunner.checkoutPage.cityInput.sendKeys("Testville");
        MainRunner.checkoutPage.stateInput.sendKeys("Testississippi");
        MainRunner.checkoutPage.zipInput.sendKeys("86753");
        MainRunner.checkoutPage.countryInput.sendKeys("Canada");
    }
    @When("The user clicks next")
    public void the_user_clicks_next() {
        MainRunner.checkoutPage.nextBtn.click();
    }
    @When("The user selects a payment method")
    public void the_user_selects_a_payment_method() {
        MainRunner.checkoutPage.paymentOptCheckbox.click();
    }
    @When("The user clicks the submit payment button")
    public void the_user_clicks_the_submit_payment_button() {
        MainRunner.checkoutPage.submitPaymentBtn.click();
    }
    @When("The user clicks the place order button")
    public void the_user_clicks_the_place_order_button() {
        MainRunner.checkoutPage.placeOrderBtn.click();
    }
    @Then("The user should receive a notification indicating that a transaction occurred.")
    public void the_user_should_receive_a_notification_indicating_that_a_transaction_occurred() {
        MainRunner.checkoutPage.notificationMessage.isDisplayed();
    }
}
