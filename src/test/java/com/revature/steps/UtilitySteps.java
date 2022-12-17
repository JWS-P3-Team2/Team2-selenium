package com.revature.steps;

import com.revature.MainRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UtilitySteps {

    @When("User refreshes the page")
    public void user_refreshes_the_page() {
        MainRunner.driver.navigate().refresh();
    }

    @When("User signs out")
    public void user_signs_out() {
        WebElement signOut = MainRunner.driver.findElement(
                By.xpath("//strong[text()='LOGOUT']")
        );
        signOut.click();
    }

    @Given("User is logged in with {string} and {string}")
    public void user_is_logged_in(String username, String password) {
        MainRunner.driver.get(MainRunner.loginUrl); // should be an env variable
        MainRunner.wait.until(ExpectedConditions.urlToBe(MainRunner.loginUrl));
        WebElement usernameInput = MainRunner.driver.findElement(
                By.name("email")
        );
        WebElement passwordInput = MainRunner.driver.findElement(
                By.name("password")
        );
        WebElement submit = MainRunner.driver.findElement(
                By.xpath("//button[@type='submit']")
        );
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submit.click();
        // A successful login will re-route the user to home
        MainRunner.wait.until(
                ExpectedConditions.or(
                        ExpectedConditions.urlToBe(MainRunner.homeUrl),
                        ExpectedConditions.urlToBe(MainRunner.homeUrl + "/")
                )
        );
    }

    @Then("User is on login page")
    public void user_is_on_login_page() {
        MainRunner.wait.until(
                ExpectedConditions.urlMatches(MainRunner.loginUrl + "/?")
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
        MainRunner.driver.get(MainRunner.profileUrl);
    }

    @Then("User redirected to login page")
    public void user_redirected_to_login_page() {
        try {
            MainRunner.wait.until(
                    ExpectedConditions.urlMatches(MainRunner.loginUrl + "/?")
            );
        }
        catch (TimeoutException e) {
            throw new AssertionError("user was not redirected to login");
        }
    }

}
