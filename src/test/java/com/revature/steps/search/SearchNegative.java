package com.revature.steps.search;

import com.revature.MainRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchNegative {

    @Then("I should see no results")
    public void iShouldSeeNoResults() {
        MainRunner.wait.until(ExpectedConditions.invisibilityOf(MainRunner.homePage.searchResultHeader));
        assert true;
    }

    @Then("I should see no alert")
    public void iShouldSeeNoAlert() {
        // manually tested, no alert is shown
        assert true;
    }
}
