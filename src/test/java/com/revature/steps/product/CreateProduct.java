package com.revature.steps.product;

import com.revature.MainRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateProduct {
    @When("User clicks on edit products")
    public void userClicksOnEditProducts() {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.firstProduct));
    }

    @When("User clicks create new product")
    public void userClicksCreateNewProduct() {
    }
    

    @When("User clicks back to products")
    public void userClicksBackToProducts() {
    }

    @Then("An error message should appear")
    public void anErrorMessageShouldAppear() {
    }

    @Then("The new product should not appear as the latest product")
    public void theNewProductShouldNotAppearAsTheLatestProduct() {
    }

    @When("User clicks on an existing product")
    public void userClicksOnAnExistingProduct() {
    }

    @When("User inputs {string}")
    public void userInputsProductName(String arg1) {
    }

    @When("User clicks update")
    public void userClicksUpdate() {
    }

    @Then("The product should be updated")
    public void theProductShouldBeUpdated() {
    }

    @Then("The new product should appear as the latest product")
    public void theNewProductShouldAppearAsTheLatestProduct() {
    }
}
