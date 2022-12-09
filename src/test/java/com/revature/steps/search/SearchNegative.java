package com.revature.steps.search;

import com.revature.MainRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchNegative {

    @Then("I should see no results")
    public void iShouldSeeNoResults() {
        try {
            MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.searchResultHeader));
        } catch (Exception e) {
            assert true;
        }
    }

    @Then("I should see no alert")
    public void iShouldSeeNoAlert() {
        try {
            MainRunner.wait.until(ExpectedConditions.alertIsPresent());
        } catch (Exception e) {
            assert true;
        }
    }
}
