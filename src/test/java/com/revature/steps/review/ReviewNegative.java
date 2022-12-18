package com.revature.steps.review;

import com.revature.MainRunner;
import com.revature.Urls;
import com.revature.steps.SeleniumSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ReviewNegative extends SeleniumSteps {

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        driver.get(Urls.base);

    }


    @Given("I am on the sign in page")
    public void i_am_on_the_sign_in_page() {
        driver.get("http://localhost:4200/login");
    }


    @When("I click the product link")
    public void iClickTheProductLink() {
        wait.until(ExpectedConditions.visibilityOf(reviewPage.firstProductCard));
        reviewPage.firstProductDetailsButton.click();
    }

    @Then("I should see the product modal")
    public void iShouldSeeTheProductModal() {
        // check if the product modal is displayed
        wait.until(ExpectedConditions.visibilityOf(reviewPage.productModal));
        boolean isPresent = reviewPage.productModal.isDisplayed();
        assert isPresent;
    }

    @When("I fill in the review form with valid data")
    public void iFillInTheReviewFormWithValidData() {
        // Wait for element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(reviewPage.fiveStarRating));
        reviewPage.fiveStarRating.click();
        reviewPage.reviewTextArea.sendKeys("Test Review");
    }

    @And("I click the submit button")
    public void iClickTheSubmitButton() {
        // Wait for element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(reviewPage.submitReviewButton));
        reviewPage.submitReviewButton.click();
    }

    @Then("I should not be able to submit the form")
    public void iShouldNotBeAbleToSubmitTheForm() {
        // check for the alert, if it is not found, test passes
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Assert.fail();
        } catch (Exception e) {
            Assert.assertTrue(true);
        }

    }

    @When("I fill in the email and password fields with valid credentials")
    public void iFillInTheEmailAndPasswordFieldsWithValidCredentials() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.email));
        loginPage.email.sendKeys("test@example.com");
        loginPage.password.sendKeys("guest");
    }

    @And("I click the sign in button")
    public void iClickTheSignInButton() {
        loginPage.loginButton.click();
    }

    @Then("I should be on the home page")
    public void iShouldBeOnTheHomePage() {
        // check url to see if it is the home page
        wait.until(ExpectedConditions.urlToBe("http://localhost:4200/"));
        assert driver.getCurrentUrl().equals("http://localhost:4200/");
    }

    @When("I click on a rating")
    public void iClickOnARating() {
        reviewPage.fiveStarRating.click();
    }

    @And("I fill in the comment field with a comment that is too long")
    public void iFillInTheCommentFieldWithACommentThatIsTooLong() {
        // fill in the comment field with a comment that is over 255 characters
        reviewPage.reviewTextArea.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor");
    }

    @When("I click the product details link")
    public void iClickTheProductDetailsLink() {
        // explicitly wait for the product details button to load
        wait.until(ExpectedConditions.visibilityOf(reviewPage.productPageOpenButton));
        reviewPage.productPageOpenButton.click();
    }

    @Then("I should see the product details page")
    public void iShouldSeeTheProductDetailsPage() {
        // wait for the product page header to be visible
        wait.until(ExpectedConditions.visibilityOf(reviewPage.productPageHeader));
        boolean isPresent = reviewPage.productPageHeader.isDisplayed();
        assert isPresent;
    }
}
