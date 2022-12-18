package com.revature.steps.checkout;

import com.revature.MainRunner;
import com.revature.steps.SeleniumSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TransactionNotification extends SeleniumSteps {

    @Given("The User has logged in")
    public void the_user_has_logged_in() {
        driver.get("http://localhost:4200/");
        wait.until(ExpectedConditions.visibilityOf(homePage.signInLink));
        homePage.signInLink.click();
        wait.until(ExpectedConditions.visibilityOf(loginPage.email));
        loginPage.email.sendKeys("user-profile@example.com");
        wait.until(ExpectedConditions.visibilityOf(loginPage.password));
        loginPage.password.sendKeys("guest");
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginButton));
        loginPage.loginButton.click();
    }
    @Given("The user has added an item to their cart")
    public void the_user_has_added_an_item_to_their_cart() {
        Actions action = new Actions(driver);
        WebElement firstProduct = wait.until(ExpectedConditions.visibilityOf(homePage.firstProduct));
        action.moveToElement(firstProduct).perform();
        driver.findElement(By.xpath("//body/div[@id='root']/div[3]/div[1]/div[1]/div[1]/div[1]")).click();
        homePage.navCartLink.click();
    }
    @When("The user clicks the checkout button from the cart link")
    public void the_user_clicks_the_checkout_button_from_the_cart_link() {
        yourBagPage.checkoutNowBtn.click();
    }
    @When("The user enters a First name")
    public void the_user_enters_a_first_name() {
        checkoutPage.firstNameInput.sendKeys("testfname");
    }
    @When("The user enters a Last name")
    public void the_user_enters_a_last_name() {
        checkoutPage.lastNameInput.sendKeys("testlname");
    }
    @When("The user enters an Address")
    public void the_user_enters_an_address() {
        checkoutPage.addressInput.sendKeys("101 Test Lane");
    }
    @When("The user enters a city")
    public void the_user_enters_a_city() {
        checkoutPage.cityInput.sendKeys("Testville");
    }
    @When("The user enters a State Province or Region")
    public void the_user_enters_a_state_province_region() {
        checkoutPage.stateInput.sendKeys("Testississippi");
    }
    @When("The user enters a Zip or Postal code")
    public void the_user_enters_a_zip_postal_code() {
        checkoutPage.zipInput.sendKeys("86753");
    }
    @When("The user enters a Country")
    public void the_user_enters_a_country() {
        checkoutPage.countryInput.sendKeys("Canada");
    }
    @When("The user clicks next")
    public void the_user_clicks_next() {
        checkoutPage.nextBtn.click();
    }
    @When("The user selects a payment method")
    public void the_user_selects_a_payment_method() {
        checkoutPage.paymentOptCheckbox.click();
    }
    @When("The user clicks the submit payment button")
    public void the_user_clicks_the_submit_payment_button() {
        checkoutPage.submitPaymentBtn.click();
    }
    @When("The user clicks the place order button")
    public void the_user_clicks_the_place_order_button() {
        checkoutPage.placeOrderBtn.click();
    }
    @Then("The user should receive a notification indicating that a transaction occurred.")
    public void the_user_should_receive_a_notification_indicating_that_a_transaction_occurred() {
        checkoutPage.notificationMessage.isDisplayed();
    }
}
