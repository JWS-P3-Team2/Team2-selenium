package com.revature.steps.review;


import com.revature.MainRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ReviewPositive {

    @And("I fill in the review field with {string}")
    public void iFillInTheReviewFieldWithString(String string) {
        MainRunner.reviewPage.reviewTextArea.sendKeys(string);
    }


    @Then("I should see the review under product reviews with {string}")
    public void iShouldSeeTheReviewUnderProductReviewsWithString(String string) {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.reviewPage.reviewTextModal));
        String reviewText = MainRunner.reviewPage.reviewTextModal.getText();
        Assert.assertEquals(reviewText, string);
    }

    @And("I click the submit button on the modal")
    public void iClickTheSubmitButtonOnTheModal() {
        MainRunner.wait.until(ExpectedConditions.elementToBeClickable(MainRunner.reviewPage.submitReviewButton));
        MainRunner.reviewPage.submitReviewButton.click();
    }


    @When("I click on a product")
    public void iClickOnAProduct() {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.reviewPage.firstProductCard));
        MainRunner.reviewPage.secondProductDetailsButton.click();
    }

    @When("I click the delete button on the review")
    public void iClickTheDeleteButtonOnTheReview() {
        MainRunner.wait.until(ExpectedConditions.elementToBeClickable(MainRunner.reviewPage.productModalDeleteButton));
        MainRunner.reviewPage.productModalDeleteButton.click();
    }


    @Then("I should see no reviews under product reviews")
    public void iShouldSeeNoReviewsUnderProductReviews() {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.reviewPage.noReviewsText));
        String noReviewsText = MainRunner.reviewPage.noReviewsText.getText();
        Assert.assertEquals(noReviewsText, "No reviews..");
    }

    @Then("I should not see the review under product reviews with {string}")
    public void iShouldNotSeeTheReviewUnderProductReviewsWith(String arg0) {
        // check if the review is not present
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.reviewPage.reviewTextModal));
        String reviewText = MainRunner.reviewPage.reviewTextModal.getText();
        Assert.assertNotEquals(reviewText, arg0);
    }
}
