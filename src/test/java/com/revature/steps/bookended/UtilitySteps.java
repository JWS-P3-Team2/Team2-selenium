package com.revature.steps.bookended;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UtilitySteps extends SeleniumSteps {

    private static String loginUrl = "http://localhost:4200/login";
    private static String homeUrl = "http://localhost:4200";

    @When("User refreshes the page")
    public void user_refreshes_the_page() {
        driver.navigate().refresh();
    }

    @When("User signs out")
    public void user_signs_out() {
        driver.findElement(
                By.xpath("//strong[text()='LOGOUT']")
        );
    }

    @Given("User is logged in with {string} and {string}")
    public void user_is_logged_in(String username, String password) {
        driver.get(loginUrl); // should be an env variable
        wait.until(ExpectedConditions.urlToBe(loginUrl));
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
                        ExpectedConditions.urlToBe(homeUrl),
                        ExpectedConditions.urlToBe(homeUrl + "/")
                )
        );
    }

    @Then("User is on login page")
    public void user_is_on_login_page() {
        wait.until(
                ExpectedConditions.urlMatches(loginUrl + "/?")
        );
    }

    @Then("User cannot login with {string} and {string}")
    public void user_cannot_login_with_and(String username, String password) {
        try {
            user_is_logged_in(username, password);
            throw new AssertionError("user was able to login with deactivated account");
        }
        catch (TimeoutException e) {
            // failure to login will result in a timeout exception
        }
    }

}
