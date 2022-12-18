package com.revature.steps.register;

import com.revature.MainRunner;
import com.revature.steps.SeleniumSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class RegisterPositive extends SeleniumSteps {
    @When("User clicks on Register link")
    public void user_clicks_on_register_link() {
        wait.until(ExpectedConditions.visibilityOf(homePage.registerLink));
        homePage.registerLink.click();
    }

    @When("User types {string} into firstname field")
    public void user_types_firstname_into_firstname_field(String string) {
        wait.until(ExpectedConditions.visibilityOf(registerPage.firstName));
        registerPage.firstName.sendKeys(string);
    }

    @When("User types {string} into lastname field")
    public void user_types_lastname_into_lastname_field(String string) {
        wait.until(ExpectedConditions.visibilityOf(registerPage.lastName));
        registerPage.lastName.sendKeys(string);
    }

    @When("User types {string} into email registration field")
    public void user_types_email_into_email_registration_field(String string) {
        wait.until(ExpectedConditions.visibilityOf(registerPage.email));
        registerPage.email.sendKeys(string);
    }

    @When("User types {string} into password registration field")
    public void user_types_password_into_password_registration_field(String string) {
        wait.until(ExpectedConditions.visibilityOf(registerPage.password));
        registerPage.password.sendKeys(string);
    }

    @When("User clicks Sign Up Button")
    public void user_clicks_sign_up_button() {
        wait.until(ExpectedConditions.visibilityOf(registerPage.loginButton));
        registerPage.loginButton.click();
    }

    //If you don't wait for the log in page,
    //Selenium assumes LOG IN email & password are REGISTER email & password.
    //(They are the same ID despite being on different forms)
    //It will input data into the REGISTER form even as the form moves to LOGIN,
    //Where the data should actually go.
    @When("User waits for log in page")
    public void userWaitsForLogInPage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(loginPage.signInTitle));
        } catch (Exception e) {
            Assert.assertEquals(false, true, "Registration form not submitted");
        }
    }

    @When("User waits for log in page fruitlessly")
    public void userWaitsForLogInPageFruitlessly() {
        try {
            wait.until(ExpectedConditions.visibilityOf(loginPage.signInTitle));
            Assert.fail("User did get logged in!");
        } catch (TimeoutException e) {
            //If we get here, this is good (negative test)
        }
    }
}
