package com.revature.steps.login;

import com.revature.Urls;
import com.revature.steps.SeleniumSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginSteps extends SeleniumSteps {

    @When("User clicks on Sign In link")
    public void user_clicks_on_sign_in_link() {
        wait.until(ExpectedConditions.visibilityOf(homePage.signInLink));
        homePage.signInLink.click();
    }
    @When("User types {string} into email field")
    public void user_types_into_email_field(String string) {
        wait.until(ExpectedConditions.visibilityOf(loginPage.email));
        loginPage.email.sendKeys(string);
    }
    @When("User types {string} into password field")
    public void user_types_into_password_field(String string) {
        wait.until(ExpectedConditions.visibilityOf(loginPage.password));
        loginPage.password.sendKeys(string);
    }
    @When("User clicks Sign In Button")
    public void user_clicks_sign_up_button() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginButton));
        loginPage.loginButton.click();
    }

    @Then("User should click on Profile link")
    public void user_should_click_on_profile_link() {
        try {
            wait.until(ExpectedConditions.visibilityOf(homePage.profileLink));
            homePage.profileLink.click();
        } catch (Exception e) {
            Assert.assertEquals(false,true,"User not logged in!");
        }
    }

    @Then("User should see {string} in greeting")
    public void user_should_see_in_greeting(String string) {
        wait.until(ExpectedConditions.visibilityOf(profile.profileGreeting));
        boolean isPresent = profile.profileGreeting.getText().contains(string);
        Assert.assertEquals(isPresent, true, "User name is not on Profile!");
    }

    @Then("User will appear on homepage")
    public void user_will_appear_on_homepage() {
        wait.until(
            ExpectedConditions.urlMatches("http://localhost:4200/?")
        );
    }


}
