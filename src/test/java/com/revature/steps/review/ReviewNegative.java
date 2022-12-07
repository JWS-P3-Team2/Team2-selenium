package com.revature.steps.review;

import com.revature.MainRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ReviewNegative {

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        MainRunner.driver.get(MainRunner.webURL);

    }


    @Given("I am on the sign in page")
    public void i_am_on_the_sign_in_page() {
        MainRunner.driver.get("http://localhost:4200/login");
    }


    @When("I click the product link")
    public void iClickTheProductLink() {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.reviewPage.firstProductCard));
        MainRunner.reviewPage.firstProductDetailsButton.click();
    }

    @Then("I should see the product modal")
    public void iShouldSeeTheProductModal() {
        // check if the product modal is displayed
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.reviewPage.productModal));
        boolean isPresent = MainRunner.reviewPage.productModal.isDisplayed();
        assert isPresent;
    }

    @When("I fill in the review form with valid data")
    public void iFillInTheReviewFormWithValidData() {
        // Wait for element to be clickable
        MainRunner.wait.until(ExpectedConditions.elementToBeClickable(MainRunner.reviewPage.fiveStarRating));
        MainRunner.reviewPage.fiveStarRating.click();
        MainRunner.reviewPage.reviewTextArea.sendKeys("Test Review");
    }

    @And("I click the submit button")
    public void iClickTheSubmitButton() {
        // Wait for element to be clickable
        MainRunner.wait.until(ExpectedConditions.elementToBeClickable(MainRunner.reviewPage.submitReviewButton));
        MainRunner.reviewPage.submitReviewButton.click();
    }

    @Then("I should not be able to submit the form")
    public void iShouldNotBeAbleToSubmitTheForm() {
        // check for the alert, if it is not found, test passes
        try {
            MainRunner.wait.until(ExpectedConditions.alertIsPresent());
            Assert.fail();
        } catch (Exception e) {
            Assert.assertTrue(true);
        }

    }

    @When("I fill in the email and password fields with valid credentials")
    public void iFillInTheEmailAndPasswordFieldsWithValidCredentials() {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.loginPage.email));
        MainRunner.loginPage.email.sendKeys("bobby@gmail.com");
        MainRunner.loginPage.password.sendKeys("password");
    }

    @And("I click the sign in button")
    public void iClickTheSignInButton() {
        MainRunner.loginPage.loginButton.click();
    }

    @Then("I should be on the home page")
    public void iShouldBeOnTheHomePage() {
        // check url to see if it is the home page
        MainRunner.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/"));
        assert MainRunner.driver.getCurrentUrl().equals("http://localhost:4200/");
    }

    @When("I click on a rating")
    public void iClickOnARating() {
        MainRunner.reviewPage.fiveStarRating.click();
    }

    @And("I fill in the comment field with a comment that is too long")
    public void iFillInTheCommentFieldWithACommentThatIsTooLong() {
        // fill in the comment field with a comment that is over 255 characters
        MainRunner.reviewPage.reviewTextArea.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor, nisl eget ultricies luctus, nisl nisl aliquet nisl, eget aliquet nisl nisl eget nisl. Donec auctor");
    }

    @When("I click the product details link")
    public void iClickTheProductDetailsLink() {
        // explicitly wait for the product details button to load
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.reviewPage.productPageOpenButton));
        MainRunner.reviewPage.productPageOpenButton.click();
    }

    @Then("I should see the product details page")
    public void iShouldSeeTheProductDetailsPage() {
        // wait for the product page header to be visible
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.reviewPage.productPageHeader));
        boolean isPresent = MainRunner.reviewPage.productPageHeader.isDisplayed();
        assert isPresent;
    }
}
