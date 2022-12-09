package com.revature.steps.search;

import com.revature.MainRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SearchPositive {

    @Given("I am currently on the home page")
    public void iAmCurrentlyOnTheHomePage() throws InterruptedException {
        MainRunner.driver.get(MainRunner.webURL);
        // using thread.sleep because wait.until was not working as expected
        // will need to look into this further
        Thread.sleep(1000);
    }

    @When("I type {string} in the search field")
    public void iTypeInTheSearchField(String arg0) {
        // wait for the search field to be visible
        //MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.searchInput));
        MainRunner.homePage.searchInput.sendKeys(arg0);
    }


    @And("I click the search button")
    public void iClickTheSearchButton() throws InterruptedException {
        MainRunner.wait.until(ExpectedConditions.elementToBeClickable(MainRunner.homePage.searchButton));
        MainRunner.homePage.searchButton.click();
        // need to go back to try and fix the wait.until
        Thread.sleep(1000);
    }

    @Then("I should see the search results page populated with products related to {string}")
    public void iShouldSeeTheSearchResultsPagePopulatedWithProductsRelatedTo(String arg0) {
        // use a try catch block to check if the search results are present
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.searchResultHeader));
        try {

            String searchResultHeader = MainRunner.homePage.searchResultHeader.getText();
            // check if the search result includes the search term
            Assert.assertTrue(searchResultHeader.contains(arg0));
        } catch (Exception e) {
            Assert.fail();
        }
    }
}
