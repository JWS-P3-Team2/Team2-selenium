package com.revature.steps.register;

import com.revature.MainRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class RegisterPositive {
    @When("User clicks on Register link")
    public void user_clicks_on_register_link() {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.registerLink));
        MainRunner.homePage.registerLink.click();
    }

    @When("User types {string} into firstname field")
    public void user_types_firstname_into_firstname_field(String string) {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.registerPage.firstName));
        MainRunner.registerPage.firstName.sendKeys(string);
    }

    @When("User types {string} into lastname field")
    public void user_types_lastname_into_lastname_field(String string) {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.registerPage.lastName));
        MainRunner.registerPage.lastName.sendKeys(string);
    }

    @When("User types {string} into email registration field")
    public void user_types_email_into_email_registration_field(String string) {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.registerPage.email));
        MainRunner.registerPage.email.sendKeys(string);
    }

    @When("User types {string} into password registration field")
    public void user_types_password_into_password_registration_field(String string) {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.registerPage.password));
        MainRunner.registerPage.password.sendKeys(string);
    }

    @When("User clicks Sign Up Button")
    public void user_clicks_sign_up_button() {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.registerPage.loginButton));
        MainRunner.registerPage.loginButton.click();
    }

    //If you don't wait for the log in page,
    //Selenium assumes LOG IN email & password are REGISTER email & password.
    //(They are the same ID despite being on different forms)
    //It will input data into the REGISTER form even as the form moves to LOGIN,
    //Where the data should actually go.
    @When("User waits for log in page")
    public void userWaitsForLogInPage() {
        try {
            MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.loginPage.signInTitle));
        } catch (Exception e) {
            Assert.assertEquals(false, true, "Registration form not submitted");
        }
    }
}
