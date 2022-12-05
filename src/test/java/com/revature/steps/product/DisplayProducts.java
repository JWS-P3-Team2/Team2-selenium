package com.revature.steps.product;

import com.revature.MainRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DisplayProducts {
    @Then("The user should see a list of available products")
    public void theUserShouldSeeAListOfAvailableProducts() {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.firstProduct));
    }
}
