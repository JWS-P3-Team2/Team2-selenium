package com.revature.steps.checkout;

import com.revature.MainRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.NoSuchElementException;

public class Checkout {
    int productCounter;

    private void awaitHomePageProducts() {
        MainRunner.wait.until(driver -> (MainRunner.homePage.allProducts.size() != 0));
    }
    @Then("The item the user bought should be removed from the inventory")
    public void theItemTheUserBoughtShouldBeRemovedFromTheInventory() {
        awaitHomePageProducts();
        int newProductSize = MainRunner.homePage.allProducts.size();
        Assert.assertTrue(newProductSize > productCounter);

    }

    @When("The user inputs {string} into the firstname field")
    public void theUserInputsFirstnameIntoTheFirstnameField(String arg1) {
        MainRunner.checkoutPage.firstNameInput.sendKeys(arg1);
    }

    @When("The user inputs {string} into the lastname field")
    public void theUserInputsLastnameIntoTheLastnameField(String arg1) {
        MainRunner.checkoutPage.lastNameInput.sendKeys(arg1);

    }

    @When("The user inputs {string} into the addressLine field")
    public void theUserInputsAddressLineIntoTheAddressLineField(String arg1) {
        MainRunner.checkoutPage.addressInput.sendKeys(arg1);

    }

    @When("The user inputs {string} into the city field")
    public void theUserInputsCityIntoTheCityField(String arg1) {
        MainRunner.checkoutPage.cityInput.sendKeys(arg1);

    }

    @When("The user inputs {string} into the zip field")
    public void theUserInputsZipIntoTheZipField(String arg1) {
        MainRunner.checkoutPage.zipInput.sendKeys(arg1);
    }

    @When("The user inputs {string} into the state field")
    public void theUserInputsStateIntoTheStateField(String arg1) {
        MainRunner.checkoutPage.stateInput.sendKeys(arg1);

    }

    @When("The user inputs {string} into the country field")
    public void theUserInputsCountryIntoTheCountryField(String arg1) {
        MainRunner.checkoutPage.countryInput.sendKeys(arg1);
    }

    @Given("Products are visible")
    public void productsAreVisible() {
        awaitHomePageProducts();
        productCounter = MainRunner.homePage.allProducts.size();
    }

    @Then("Then an error message should appear")
    public void thenAnErrorMessageShouldAppear() throws InterruptedException {
        boolean tooltipDisplayed = false;
        if (MainRunner.checkoutPage.firstNameInputToolTip.size() > 0) {
            tooltipDisplayed = true;
        }
        if (MainRunner.checkoutPage.lastNameInputInputToolTip.size() > 0) {
            tooltipDisplayed = true;
        }
        if (MainRunner.checkoutPage.addressInputInputToolTip.size() > 0) {
            tooltipDisplayed = true;
        }
        if (MainRunner.checkoutPage.cityInputInputToolTip.size() > 0) {
            tooltipDisplayed = true;
        }
        if (MainRunner.checkoutPage.zipInputInputToolTip.size() > 0) {
            tooltipDisplayed = true;
        }
        if (MainRunner.checkoutPage.stateInputInputToolTip.size() > 0) {
            tooltipDisplayed = true;
        }
        if (MainRunner.checkoutPage.countryInputInputToolTip.size() > 0) {
            tooltipDisplayed = true;
        }

        Assert.assertTrue(tooltipDisplayed);
    }

    @Then("The user should still be on shipping address")
    public void theUserShouldStillBeOnShippingAddress() {
    try{
        Assert.assertTrue(MainRunner.checkoutPage.firstNameInput.isDisplayed());
    }catch (NoSuchElementException e){
        Assert.fail();
    }
    }
}
