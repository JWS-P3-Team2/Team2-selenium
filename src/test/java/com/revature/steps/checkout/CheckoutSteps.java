package com.revature.steps.checkout;

import com.revature.steps.SeleniumSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.NoSuchElementException;

public class CheckoutSteps extends SeleniumSteps {
    int productCounter;

    private void awaitHomePageProducts() {
        wait.until(driver -> (homePage.allProducts.size() != 0));
    }
    @Then("The item the user bought should be removed from the inventory")
    public void theItemTheUserBoughtShouldBeRemovedFromTheInventory() {
        awaitHomePageProducts();
        int newProductSize = homePage.allProducts.size();
        Assert.assertTrue(newProductSize > productCounter);

    }

    @When("The user inputs {string} into the firstname field")
    public void theUserInputsFirstnameIntoTheFirstnameField(String arg1) {
        checkoutPage.firstNameInput.sendKeys(arg1);
    }

    @When("The user inputs {string} into the lastname field")
    public void theUserInputsLastnameIntoTheLastnameField(String arg1) {
        checkoutPage.lastNameInput.sendKeys(arg1);

    }

    @When("The user inputs {string} into the addressLine field")
    public void theUserInputsAddressLineIntoTheAddressLineField(String arg1) {
        checkoutPage.addressInput.sendKeys(arg1);

    }

    @When("The user inputs {string} into the city field")
    public void theUserInputsCityIntoTheCityField(String arg1) {
        checkoutPage.cityInput.sendKeys(arg1);

    }

    @When("The user inputs {string} into the zip field")
    public void theUserInputsZipIntoTheZipField(String arg1) {
        checkoutPage.zipInput.sendKeys(arg1);
    }

    @When("The user inputs {string} into the state field")
    public void theUserInputsStateIntoTheStateField(String arg1) {
        checkoutPage.stateInput.sendKeys(arg1);

    }

    @When("The user inputs {string} into the country field")
    public void theUserInputsCountryIntoTheCountryField(String arg1) {
        checkoutPage.countryInput.sendKeys(arg1);
    }

    @Given("Products are visible")
    public void productsAreVisible() {
        awaitHomePageProducts();
        productCounter = homePage.allProducts.size();
    }

    @Then("Then an error message should appear")
    public void thenAnErrorMessageShouldAppear() throws InterruptedException {
        boolean tooltipDisplayed = false;
        if (checkoutPage.firstNameInputToolTip.size() > 0) {
            tooltipDisplayed = true;
        }
        if (checkoutPage.lastNameInputInputToolTip.size() > 0) {
            tooltipDisplayed = true;
        }
        if (checkoutPage.addressInputInputToolTip.size() > 0) {
            tooltipDisplayed = true;
        }
        if (checkoutPage.cityInputInputToolTip.size() > 0) {
            tooltipDisplayed = true;
        }
        if (checkoutPage.zipInputInputToolTip.size() > 0) {
            tooltipDisplayed = true;
        }
        if (checkoutPage.stateInputInputToolTip.size() > 0) {
            tooltipDisplayed = true;
        }
        if (checkoutPage.countryInputInputToolTip.size() > 0) {
            tooltipDisplayed = true;
        }

        Assert.assertTrue(tooltipDisplayed);
    }

    @Then("The user should still be on shipping address")
    public void theUserShouldStillBeOnShippingAddress() {
    try{
        Assert.assertTrue(checkoutPage.firstNameInput.isDisplayed());
    }catch (NoSuchElementException e){
        Assert.fail();
    }
    }
}
