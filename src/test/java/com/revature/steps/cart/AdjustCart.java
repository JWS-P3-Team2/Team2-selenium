package com.revature.steps.cart;

import com.revature.pages.Cart;
import com.revature.steps.SeleniumSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AdjustCart extends SeleniumSteps {

    private static Cart cartPage = new Cart(driver);

    @When("User clicks on cart button")
    public void user_clicks_on_cart_button() {
        cartPage.cartLink.click();
    }

    @Then("User should see item in cart")
    public void user_should_see_item_in_cart() {
        try {
            wait.until(ExpectedConditions.visibilityOf(cartPage.productDiv));
        } catch (Exception e) {
            Assert.assertEquals(false,true,"No product found!");
        }
    }

    @Then("User clicks on add button and amounts increase")
    public void user_clicks_on_add_button_and_amounts_increase() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(cartPage.firstProductAmount));
        int amount = Integer.valueOf(cartPage.firstProductAmount.getText());
        cartPage.addButton.click();
        int amount2 = Integer.valueOf(cartPage.firstProductAmount.getText());
        Assert.assertEquals((amount + 1 == amount2), true, "Error: Amount of product did not increase!");
    }

    @Then("User clicks on subtract button and amounts decrease")
    public void user_clicks_on_subtract_button_and_amounts_decrease() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(cartPage.firstProductAmount));
        int amount = Integer.valueOf(cartPage.firstProductAmount.getText());
        cartPage.subtractButton.click();
        int amount2 = Integer.valueOf(cartPage.firstProductAmount.getText());
        Assert.assertEquals((amount - 1 == amount2), true, "Error: Amount of product did not increase!");
    }

    @Then("User clicks on trash button and product is removed")
    public void user_clicks_on_trash_button_and_product_is_removed() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(cartPage.firstProductNumber));
        String productOrder = cartPage.firstProductNumber.getText().substring(4);
        wait.until(ExpectedConditions.visibilityOf(cartPage.trashButton));
        cartPage.trashButton.click();
        try {
            wait.until(ExpectedConditions.visibilityOf(cartPage.firstProductNumber));
            String productOrder2 = cartPage.firstProductNumber.getText().substring(4);
            Assert.assertEquals(productOrder.equals(productOrder2), true, "Error: Product was not deleted!");
        } catch (Exception e) {
            //If it can't find an element, then good. It means it was deleted.
        }
    }
}
