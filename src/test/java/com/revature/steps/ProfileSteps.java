package com.revature.steps;

import com.revature.modules.*;
import com.revature.pages.ProfilePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class ProfileSteps extends CachingSteps {

    @BeforeAll
    public static void initialize() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup() {
        cache = new HashMap<>();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    @After
    public void cleanup() {
        cache.clear();
        driver.quit();
    }

    @Given("User is logged in")
    public void user_is_logged_in() {
        driver.get(loginUrl); // should be an env variable
        wait.until(ExpectedConditions.urlToBe(loginUrl));
        WebElement username = driver.findElement(
                By.name("email")
        );
        WebElement password = driver.findElement(
                By.name("password")
        );
        WebElement submit = driver.findElement(
                By.xpath("//button[@type='submit']")
        );
        username.sendKeys("user-profile@example.com");
        password.sendKeys("guest");
        submit.click();
        // A successful login will re-route the user to home
        wait.until(
            ExpectedConditions.or(
                ExpectedConditions.urlToBe(homeUrl),
                ExpectedConditions.urlToBe(homeUrl + "/")
            )
        );
    }

    @Given("User is on profile page")
    public void user_is_on_profile_page() {
        driver.get(profileUrl);
        wait.until(ExpectedConditions.urlToBe(profileUrl));
        cache.put(
                "profile-page",
                PageFactory.initElements(driver, ProfilePage.class)
        );
    }

    @Given("User located the update-profile module")
    public void user_located_the_update_profile_module() {
        ProfilePage page = (ProfilePage) cache.get("profile-page");
        WebElement updateProfile = wait.until(
            ExpectedConditions.visibilityOf(
                page.updateProfile
            )
        );
        cache.put(
                "update-profile",
                PageFactory.initElements(updateProfile, UpdateProfileModule.class)
        );
    }

    @Then("update-profile module has input named firstName")
    public void update_profile_module_has_input_named_first_name() {
        UpdateProfileModule module = (UpdateProfileModule) cache.get("update-profile");
        wait.until(
            ExpectedConditions.visibilityOf(module.firstNameInput)
        );
    }

    @Then("update-profile module has input named lastName")
    public void update_profile_module_has_input_named_last_name() {
        UpdateProfileModule module = (UpdateProfileModule) cache.get("update-profile");
        wait.until(
                ExpectedConditions.visibilityOf(module.lastNameInput)
        );
    }

    @Then("update-profile module has input named password")
    public void update_profile_module_has_input_named_password() {
        UpdateProfileModule module = (UpdateProfileModule) cache.get("update-profile");
        wait.until(
                ExpectedConditions.visibilityOf(module.passwordInput)
        );
    }

    @Then("update-profile module has button containing text Update")
    public void update_profile_module_has_button_containing_text_update() {
        UpdateProfileModule module = (UpdateProfileModule) cache.get("update-profile");
        wait.until(
                ExpectedConditions.visibilityOf(module.updateButton)
        );
    }

    @Given("User located the deactivate-account module")
    public void user_located_the_deactivate_account_module() {
        ProfilePage page = (ProfilePage) cache.get("profile-page");
        WebElement context = wait.until(
                ExpectedConditions.visibilityOf(
                        page.deactivateAccount
                )
        );
        cache.put(
                "deactivate-account",
                PageFactory.initElements(context, DeactivateAccountModule.class)
        );
    }

    @Then("deactivate-account has deactivateInput")
    public void deactivate_account_has_deactivate_input() {
        DeactivateAccountModule module = (DeactivateAccountModule) cache.get("deactivate-account");
        wait.until(
                ExpectedConditions.visibilityOf(module.deactivateInput)
        );
    }

    @Then("deactivate-account has deactivateButton")
    public void deactivate_account_has_deactivate_button() {
        DeactivateAccountModule module = (DeactivateAccountModule) cache.get("deactivate-account");
        wait.until(
                ExpectedConditions.visibilityOf(module.deactivateButton)
        );
    }

    @Given("User located the payment-management module")
    public void user_located_the_payment_management_module() {
        ProfilePage page = (ProfilePage) cache.get("profile-page");
        WebElement context = wait.until(
                ExpectedConditions.visibilityOf(
                        page.paymentManagement
                )
        );
        cache.put(
                "payment-management",
                PageFactory.initElements(context, PaymentManagementModule.class)
        );
    }

    @Then("payment-management has cardNumberInput")
    public void payment_management_has_card_number_input() {
        PaymentManagementModule module = (PaymentManagementModule) cache.get("payment-management");
        wait.until(
                ExpectedConditions.visibilityOf(module.cardNumberInput)
        );
    }

    @Then("payment-management has expirationInput")
    public void payment_management_has_expiration_input() {
        PaymentManagementModule module = (PaymentManagementModule) cache.get("payment-management");
        wait.until(
                ExpectedConditions.visibilityOf(module.expDateInput)
        );
    }

    @Then("payment-management has ccvInput")
    public void payment_management_has_ccv_input() {
        PaymentManagementModule module = (PaymentManagementModule) cache.get("payment-management");
        wait.until(
                ExpectedConditions.visibilityOf(module.ccvInput)
        );
    }

    @Then("payment-management has addButton")
    public void payment_management_has_add_button() {
        PaymentManagementModule module = (PaymentManagementModule) cache.get("payment-management");
        wait.until(
                ExpectedConditions.visibilityOf(module.addPaymentButton)
        );
    }

    @Given("User located the payment-table module")
    public void user_located_the_payment_table_module() {
        PaymentManagementModule module = (PaymentManagementModule) cache.get("payment-management");
        WebElement context = wait.until(
                ExpectedConditions.visibilityOf(module.paymentTable)
        );
        cache.put(
                "payment-table",
                PageFactory.initElements(context, TableModule.class)
        );
    }

    @Then("^payment-table headers contains (.+)$")
    public void payment_table_headers_contains(String heading) {
        TableModule paymentTable = (TableModule) cache.get("payment-table");
        List<String> paymentHeaderText = paymentTable.headers.stream().map(
                element -> element.getText()
        ).collect(Collectors.toList());
        paymentHeaderText.contains(heading);
    }

    @Given("User located a payment-row module")
    public void user_located_a_payment_row_module() {
        TableModule paymentTable = (TableModule) cache.get("payment-table");
        List<WebElement> rows = paymentTable.rows;
        wait.until(
                ExpectedConditions.visibilityOf(rows.get(0))
        );
        cache.put(
                "payment-row",
                PageFactory.initElements(rows.get(0), PaymentRowModule.class)
        );
    }

    @Then("payment-row cardNumber")
    public void payment_row_card_number() {
        PaymentRowModule module = (PaymentRowModule) cache.get("payment-row");
        wait.until(
                ExpectedConditions.visibilityOf(module.cardNumberTd)
        );
    }

    @Then("payment-row expirationDate")
    public void payment_row_expiration_date() {
        PaymentRowModule module = (PaymentRowModule) cache.get("payment-row");
        wait.until(
                ExpectedConditions.visibilityOf(module.expDateTd)
        );
    }

    @Then("payement-row ccv")
    public void payement_row_ccv() {
        PaymentRowModule module = (PaymentRowModule) cache.get("payment-row");
        wait.until(
                ExpectedConditions.visibilityOf(module.ccvTd)
        );
    }

    @Then("payment-row deleteButton")
    public void payment_row_delete_button() {
        PaymentRowModule module = (PaymentRowModule) cache.get("payment-row");
        wait.until(
                ExpectedConditions.visibilityOf(module.deleteButton)
        );
    }

}
