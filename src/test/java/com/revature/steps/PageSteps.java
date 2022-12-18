package com.revature.steps;

import com.revature.Urls;
import com.revature.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PageSteps extends SeleniumSteps {
    @Given("I am currently on the home page") // switch to navigates to
    public void iAmCurrentlyOnTheHomePage() throws InterruptedException {
        driver.get(Urls.base);
        wait.until(
                ExpectedConditions.urlMatches(Urls.base + "/?")
        );
        homePage = new Home(driver);
    }

    @Given("User is on the home page") // switch to navigates to
    public void user_is_on_the_home_page() throws InterruptedException {
        driver.get(Urls.base);
        wait.until(
                ExpectedConditions.urlMatches(Urls.base + "/?")
        );
        homePage = new Home(driver);
    }

    @Given("User is on profile page")
    public void user_is_on_profile_page() {
        driver.get(Urls.profile);
        wait.until(ExpectedConditions.urlToBe(Urls.profile));
        profilePage = PageFactory.initElements(
                driver,
                ProfilePage.class
        );
    }

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        driver.get(Urls.base);
        wait.until(
                ExpectedConditions.urlMatches(Urls.base + "/?")
        );
        homePage = new Home(driver);
    }

    @Given("I am on the sign in page") // should rephrase to user navigates to sign-in page
    public void i_am_on_the_sign_in_page() {
        driver.get("http://localhost:4200/login");
        wait.until(
                ExpectedConditions.urlMatches(Urls.login + "/?")
        );
        loginPage = new Login(driver);
    }

    @Then("User is on login page")
    public void user_is_on_login_page() {
        wait.until(
                ExpectedConditions.urlMatches(Urls.login + "/?")
        );
        loginPage = new Login(driver);
    }

    @When("User waits for log in page")
    public void userWaitsForLogInPage() {
        wait.until(
                ExpectedConditions.urlMatches(Urls.login + "/?")
        );
        loginPage = new Login(driver);
    }

    @Given("I am on the product review page")
    public void i_am_on_the_product_review_page() {
        wait.until(
                ExpectedConditions.urlMatches(Urls.base + "/?")
        );
        reviewPage = new Review(driver);
    }

    @Given("User is on the register page")
    public void user_is_on_the_register_page() {
        wait.until(
                ExpectedConditions.urlMatches(Urls.register + "/?")
        );
        registerPage = new Register(driver);
    }
}
