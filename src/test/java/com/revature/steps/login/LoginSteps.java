package com.revature.steps.login;

import com.revature.MainRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginSteps {
    @Given("User is on the home page")
    public void user_is_on_the_home_page() throws InterruptedException {
        MainRunner.driver.get(MainRunner.webURL);
    }

    @When("User clicks on Sign In link")
    public void user_clicks_on_sign_in_link() {
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
    @When("User clicks Sign In Button")
    public void user_clicks_sign_up_button() {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.loginPage.loginButton));
        MainRunner.loginPage.loginButton.click();
    }

    @Then("User should click on Profile link")
    public void user_should_click_on_profile_link() {
        try {
            MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.profileLink));
            MainRunner.homePage.profileLink.click();
        } catch (Exception e) {
            Assert.assertEquals(false,true,"User not logged in!");
        }
    }

    @Then("User should see {string} in greeting")
    public void user_should_see_in_greeting(String string) {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.profilePage.profileGreeting));
        boolean isPresent = MainRunner.profilePage.profileGreeting.getText().contains(string);
        Assert.assertEquals(isPresent, true, "User name is not on Profile!");
    }

    @Then("User will appear on homepage")
    public void user_will_appear_on_homepage() {
        MainRunner.wait.until(
            ExpectedConditions.urlMatches("http://localhost:4200/?")
        );
    }


}
