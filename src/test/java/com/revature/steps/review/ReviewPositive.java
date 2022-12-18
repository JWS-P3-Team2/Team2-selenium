package com.revature.steps.review;


import com.revature.steps.SeleniumSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ReviewPositive extends SeleniumSteps {

    @And("I fill in the review field with {string}")
    public void iFillInTheReviewFieldWithString(String string) {
        reviewPage.reviewTextArea.sendKeys(string);
    }


    @Then("I should see the review under product reviews with {string}")
    public void iShouldSeeTheReviewUnderProductReviewsWithString(String string) {
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(reviewPage.reviewTextModal, string));
            String reviewText = reviewPage.reviewTextModal.getText();
            Assert.assertEquals(reviewText, string);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @And("I click the submit button on the modal")
    public void iClickTheSubmitButtonOnTheModal() {
        wait.until(ExpectedConditions.elementToBeClickable(reviewPage.submitReviewButton));
        reviewPage.submitReviewButton.click();
    }


    @When("I click on a product")
    public void iClickOnAProduct() {
        wait.until(ExpectedConditions.visibilityOf(reviewPage.firstProductCard));
        reviewPage.secondProductDetailsButton.click();
    }

    @When("I click the delete button on the review")
    public void iClickTheDeleteButtonOnTheReview() {
        wait.until(ExpectedConditions.elementToBeClickable(reviewPage.productModalDeleteButton));
        reviewPage.productModalDeleteButton.click();
    }


    @Then("I should see no reviews under product reviews")
    public void iShouldSeeNoReviewsUnderProductReviews() {
        wait.until(ExpectedConditions.visibilityOf(reviewPage.noReviewsText));
        String noReviewsText = reviewPage.noReviewsText.getText();
        Assert.assertEquals(noReviewsText, "No reviews..");
    }

    @Then("I should not see the review under product reviews with {string}")
    public void iShouldNotSeeTheReviewUnderProductReviewsWith(String arg0) {
        // check if the review is not present
        wait.until(ExpectedConditions.visibilityOf(reviewPage.reviewTextModal));
        String reviewText = reviewPage.reviewTextModal.getText();
        Assert.assertNotEquals(reviewText, arg0);
    }
}
