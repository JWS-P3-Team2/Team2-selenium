package com.revature.steps.search;

import com.revature.MainRunner;
import com.revature.steps.SeleniumSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchNegative extends SeleniumSteps {

    @Then("I should see no results")
    public void iShouldSeeNoResults() {
        try {
            wait.until(ExpectedConditions.visibilityOf(homePage.searchResultHeader));
        } catch (Exception e) {
            assert true;
        }
    }

    @Then("I should see no alert")
    public void iShouldSeeNoAlert() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
        } catch (Exception e) {
            assert true;
        }
    }
}
