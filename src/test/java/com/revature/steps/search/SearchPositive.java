package com.revature.steps.search;

import com.revature.MainRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPositive {


    @When("I type {string} in the search field")
    public void iTypeInTheSearchField(String arg0) {
        // wait for the search field to be visible
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.searchInput));
        MainRunner.homePage.searchInput.sendKeys(arg0);
    }


    @And("I click the search button")
    public void iClickTheSearchButton() {
        MainRunner.homePage.searchButton.click();
    }

    @Then("I should see the search results page populated with products related to {string}")
    public void iShouldSeeTheSearchResultsPagePopulatedWithProductsRelatedTo(String arg0) {
        // wait for the search results to be visible
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.searchResultHeader));
        boolean isPresent = MainRunner.homePage.searchResultHeader.isDisplayed();
        if (isPresent) {
            // check the search results header to see if it is the test search
            // if it is, the test passes
            if (MainRunner.homePage.searchResultHeader.getText().equals(arg0)) {
                assert true;
            } else {
                // if the search results header is not the test search, the test fails
                assert false;
            }
        } else {
            assert false;
        }
    }
}
