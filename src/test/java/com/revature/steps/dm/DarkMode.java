package com.revature.steps.dm;

import com.revature.Urls;
import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;
import com.revature.steps.SeleniumSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DarkMode extends SeleniumSteps {
    @Given("The user is logged in and on the home page")
    public void the_registered_user_is_logged_in_and_on_the_home_page() {
        driver.get(Urls.base);
        wait.until(ExpectedConditions.urlMatches(Urls.base + "/?"));
        homePage = new HomePage(driver);
        homePage.signInLink.click();
        wait.until(ExpectedConditions.urlMatches(Urls.login + "/?"));
        loginPage = new LoginPage(driver);
        loginPage.email.sendKeys("test@example.com");
        wait.until(ExpectedConditions.visibilityOf(loginPage.password));
        loginPage.password.sendKeys("guest");
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginButton));
        loginPage.loginButton.click();
        wait.until(ExpectedConditions.urlMatches(Urls.base + "/?"));
        homePage = new HomePage(driver);
    }
    @When("The user clicks the dark mode checkbox")
    public void the_registered_user_clicks_the_dark_mode_checkbox() {
        homePage.darkModeBtn.click();
        homePage.darkModeBtn.click();
    }
    @Then("The screen changes from normal to dark mode")
    public void the_screen_changes_from_normal_to_dark_mode() {
        wait.until(driver -> {
            String darkBody = homePage.mainBody.getCssValue("background-color");
            return darkBody.equals("rgba(18, 18, 18, 1)");
        });
    }
    @When("The user clicks the profile link")
    public void the_registered_user_clicks_the_profile_link() {
        homePage.profileLink.click();
    }
    @When("The user clicks the dark mode checkbox again")
    public void the_registered_user_clicks_the_dark_mode_checkbox_again() {
        homePage.darkModeBtn.click();
    }
    @Then("The screen changes from dark mode to normal")
    public void the_screen_changes_from_dark_mode_to_normal() {
        wait.until(driver -> {
            String darkBody = homePage.mainBody.getCssValue("background-color");
            return darkBody.equals("rgba(255, 255, 255, 1)");
        });
    }
    @Then("The screen is still in dark mode")
    public void the_screen_is_still_in_dark_mode() {
        wait.until(driver -> {
            String darkBody = homePage.mainBody.getCssValue("background-color");
            return darkBody.equals("rgba(18, 18, 18, 1)");
        });
    }
    @When("The user clicks the cart link")
    public void the_registered_user_clicks_the_cart_link() {
        homePage.navCartLink.click();
    }
}
