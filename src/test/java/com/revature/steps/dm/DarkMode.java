package com.revature.steps.dm;

import com.revature.MainRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DarkMode {
    @Given("The registeredUser is logged in and on the home page")
    public void the_registered_user_is_logged_in_and_on_the_home_page() {
        MainRunner.driver.get("http://localhost:4200/");
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.signInLink));
        MainRunner.homePage.signInLink.click();
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.loginPage.email));
        MainRunner.loginPage.email.sendKeys("test@example.com");
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.loginPage.password));
        MainRunner.loginPage.password.sendKeys("guest");
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.loginPage.loginButton));
        MainRunner.loginPage.loginButton.click();
    }
    @When("The registeredUser clicks the dark mode checkbox")
    public void the_registered_user_clicks_the_dark_mode_checkbox() {
        MainRunner.homePage.darkModeBtn.click();
        MainRunner.homePage.darkModeBtn.click();
    }
    @Then("The screen changes from normal to dark mode")
    public void the_screen_changes_from_normal_to_dark_mode() {
        MainRunner.wait.until(driver -> {
            String darkBody = MainRunner.homePage.mainBody.getCssValue("background-color");
            return darkBody.equals("rgba(18, 18, 18, 1)");
        });
    }
    @When("The registeredUser clicks the profile link")
    public void the_registered_user_clicks_the_profile_link() {
        MainRunner.homePage.profileLink.click();
    }
    @When("The registeredUser clicks the dark mode checkbox again")
    public void the_registered_user_clicks_the_dark_mode_checkbox_again() {
        MainRunner.homePage.darkModeBtn.click();
    }
    @Then("The screen changes from dark mode to normal")
    public void the_screen_changes_from_dark_mode_to_normal() {
        MainRunner.wait.until(driver -> {
            String darkBody = MainRunner.homePage.mainBody.getCssValue("background-color");
            return darkBody.equals("rgba(255, 255, 255, 1)");
        });
    }
    @Given("The guest is logged in and on the home page")
    public void the_guest_is_logged_in_and_on_the_home_page() {
        MainRunner.driver.get("http://localhost:4200/");
    }
    @Given("The guest is on the home page")
    public void the_guest_is_on_the_home_page() { MainRunner.driver.get("http://localhost:4200/"); }
    @When("The guest clicks the dark mode checkbox")
    public void the_guest_clicks_the_dark_mode_checkbox() {
        MainRunner.homePage.darkModeBtn.click();
        MainRunner.homePage.darkModeBtn.click();
    }
    @When("The guest clicks the dark mode checkbox again")
    public void the_guest_clicks_the_dark_mode_checkbox_again() {
        MainRunner.homePage.darkModeBtn.click();
    }
    @When("The guest clicks the profile link")
    public void the_guest_clicks_the_profile_link() {
        MainRunner.homePage.profileLink.click();
    }
    @Then("The screen is still in dark mode")
    public void the_screen_is_still_in_dark_mode() {
        MainRunner.wait.until(driver -> {
            String darkBody = MainRunner.homePage.mainBody.getCssValue("background-color");
            return darkBody.equals("rgba(18, 18, 18, 1)");
        });
    }
    @When("The registeredUser clicks the cart link")
    public void the_registered_user_clicks_the_cart_link() {
        MainRunner.homePage.navCartLink.click();
    }
    @When("The guest clicks the cart link")
    public void the_guest_clicks_the_cart_link() {
        MainRunner.homePage.navCartLink.click();
    }
}
