package com.revature.stepimplementations.login;

import com.revature.MainRunner;
import io.cucumber.core.runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPositive {
    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        MainRunner.driver.get(MainRunner.webURL);
    }
    @When("User clicks on Register link")
    public void user_clicks_on_register_link() {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.signInLink));
        MainRunner.homePage.signInLink.click();
    }
    @When("User types {string} into email field")
    public void user_types_into_email_field(String string) {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.loginPage.email));
        MainRunner.loginPage.email.sendKeys(string);
    }
    @When("User types {string} into password field")
    public void user_types_into_password_field(String string) {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.loginPage.password));
        MainRunner.loginPage.password.sendKeys(string);
    }
    @When("User clicks Sign Up Button")
    public void user_clicks_sign_up_button() {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.loginPage.loginButton));
        MainRunner.loginPage.loginButton.click();
    }
    @Then("User will appear on sign in page")
    public void user_will_appear_on_sign_in_page() {

    }
}
