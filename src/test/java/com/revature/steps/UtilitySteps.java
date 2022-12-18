package com.revature.steps;

import com.revature.MainRunner;
import com.revature.Urls;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UtilitySteps extends SeleniumSteps {

    @When("User refreshes the page")
    public void user_refreshes_the_page() {
        driver.navigate().refresh();
    }

    @When("User signs out")
    public void user_signs_out() {
        WebElement signOut = driver.findElement(
                By.xpath("//strong[text()='LOGOUT']")
        );
        signOut.click();
    }

    @Given("User is logged in with {string} and {string}")
    public void user_is_logged_in(String username, String password) {
        driver.get(Urls.login); // should be an env variable
        wait.until(ExpectedConditions.urlToBe(Urls.login));
        WebElement usernameInput = driver.findElement(
                By.name("email")
        );
        WebElement passwordInput = driver.findElement(
                By.name("password")
        );
        WebElement submit = driver.findElement(
                By.xpath("//button[@type='submit']")
        );
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submit.click();
        // A successful login will re-route the user to home
        wait.until(
                ExpectedConditions.or(
                        ExpectedConditions.urlToBe(Urls.base),
                        ExpectedConditions.urlToBe(Urls.base + "/")
                )
        );
    }

    @Then("User is on login page")
    public void user_is_on_login_page() {
        wait.until(
                ExpectedConditions.urlMatches(Urls.login + "/?")
        );
    }

    @Then("User cannot login with {string} and {string}")
    public void user_cannot_login_with_and(String username, String password) {
        try {
            user_is_logged_in(username, password);
            throw new AssertionError("user was able to login with deactivated account");
        }
        catch (TimeoutException e) {
            // failure to login will result in a timeout exception that should be ignored
        }
    }

    @Given("User erroneously is on profile page")
    public void user_erroneously_is_on_profile_page() {
        driver.get(Urls.profile);
    }

    @Then("User redirected to login page")
    public void user_redirected_to_login_page() {
        try {
            wait.until(
                    ExpectedConditions.urlMatches(Urls.login + "/?")
            );
        }
        catch (TimeoutException e) {
            throw new AssertionError("user was not redirected to login");
        }
    }

}
