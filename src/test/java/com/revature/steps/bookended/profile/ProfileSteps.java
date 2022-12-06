package com.revature.steps.bookended.profile;

import com.revature.modules.*;
import com.revature.pages.ProfilePage;
import com.revature.steps.bookended.SeleniumSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.*;
import java.util.stream.Collectors;


public class ProfileSteps extends SeleniumSteps {

    private static String profileUrl = "http://localhost:4200/userProfile";
    private static ProfilePage profilePage;
    private static UpdateProfileModule updateProfile;
    private static PaymentRowModule paymentRow;
    private static PaymentManagementModule paymentManagement;
    private static DeactivateAccountModule deactivateAccount;
    private static TableModule paymentTable;

    @Given("User is on profile page")
    public void user_is_on_profile_page() {
        driver.get(profileUrl);
        wait.until(ExpectedConditions.urlToBe(profileUrl));
        profilePage = PageFactory.initElements(
                driver,
                ProfilePage.class
        );
    }

    @Given("User located the update-profile module")
    public void user_located_the_update_profile_module() {
        WebElement context = wait.until(
            ExpectedConditions.visibilityOf(
                profilePage.updateProfile
            )
        );
        updateProfile = PageFactory.initElements(
                context,
                UpdateProfileModule.class
        );
    }

    @Then("update-profile module has input named firstName")
    public void update_profile_module_has_input_named_first_name() {
        wait.until(
            ExpectedConditions.visibilityOf(
                    updateProfile.firstNameInput
            )
        );
    }

    @Then("update-profile module has input named lastName")
    public void update_profile_module_has_input_named_last_name() {
        wait.until(
                ExpectedConditions.visibilityOf(
                        updateProfile.lastNameInput
                )
        );
    }

    @Then("update-profile module has input named password")
    public void update_profile_module_has_input_named_password() {
        wait.until(
                ExpectedConditions.visibilityOf(
                        updateProfile.passwordInput
                )
        );
    }

    @Then("update-profile module has button containing text Update")
    public void update_profile_module_has_button_containing_text_update() {
        wait.until(
                ExpectedConditions.visibilityOf(
                        updateProfile.updateButton
                )
        );
    }

    @Given("User located the deactivate-account module")
    public void user_located_the_deactivate_account_module() {
        WebElement context = wait.until(
                ExpectedConditions.visibilityOf(
                        profilePage.deactivateAccount
                )
        );
        deactivateAccount = PageFactory.initElements(
                context,
                DeactivateAccountModule.class
        );
    }

    @Then("deactivate-account has deactivateInput")
    public void deactivate_account_has_deactivate_input() {
        wait.until(
                ExpectedConditions.visibilityOf(
                        deactivateAccount.deactivateInput
                )
        );
    }

    @Then("deactivate-account has deactivateButton")
    public void deactivate_account_has_deactivate_button() {
        wait.until(
                ExpectedConditions.visibilityOf(
                        deactivateAccount.deactivateButton
                )
        );
    }

    @Given("User located the payment-management module")
    public void user_located_the_payment_management_module() {
        WebElement context = wait.until(
                ExpectedConditions.visibilityOf(
                        profilePage.paymentManagement
                )
        );
        paymentManagement = PageFactory.initElements(
                context,
                PaymentManagementModule.class
        );
    }

    @Then("payment-management has cardNumberInput")
    public void payment_management_has_card_number_input() {
        wait.until(
                ExpectedConditions.visibilityOf(
                        paymentManagement.cardNumberInput
                )
        );
    }

    @Then("payment-management has expirationInput")
    public void payment_management_has_expiration_input() {
        wait.until(
                ExpectedConditions.visibilityOf(
                        paymentManagement.expDateInput
                )
        );
    }

    @Then("payment-management has ccvInput")
    public void payment_management_has_ccv_input() {
        wait.until(
                ExpectedConditions.visibilityOf(
                        paymentManagement.ccvInput
                )
        );
    }

    @Then("payment-management has addButton")
    public void payment_management_has_add_button() {
        wait.until(
                ExpectedConditions.visibilityOf(
                        paymentManagement.addPaymentButton
                )
        );
    }

    @Given("User located the payment-table module")
    public void user_located_the_payment_table_module() {
        WebElement context = wait.until(
                ExpectedConditions.visibilityOf(
                        paymentManagement.paymentTable
                )
        );
        paymentTable = PageFactory.initElements(
                context,
                TableModule.class
        );
    }

    @Then("^payment-table headers contains (.+)$")
    public void payment_table_headers_contains(String heading) {
        List<String> paymentHeaderText = paymentTable.headers.stream().map(
                element -> element.getText()
        ).collect(Collectors.toList());
        paymentHeaderText.contains(heading);
    }

    @Given("User located a payment-row module")
    public void user_located_a_payment_row_module() {
        List<WebElement> rows = paymentTable.rows;
        wait.until(
                ExpectedConditions.visibilityOf(rows.get(0))
        );
        paymentRow = PageFactory.initElements(
                rows.get(0),
                PaymentRowModule.class
        );
    }

    @Then("payment-row cardNumber")
    public void payment_row_card_number() {
        wait.until(
                ExpectedConditions.visibilityOf(
                        paymentRow.cardNumberTd
                )
        );
    }

    @Then("payment-row expirationDate")
    public void payment_row_expiration_date() {
        wait.until(
                ExpectedConditions.visibilityOf(
                        paymentRow.expDateTd
                )
        );
    }

    @Then("payment-row ccv")
    public void payment_row_ccv() {
        wait.until(
                ExpectedConditions.visibilityOf(
                        paymentRow.ccvTd
                )
        );
    }

    @Then("payment-row deleteButton")
    public void payment_row_delete_button() {
        wait.until(
                ExpectedConditions.visibilityOf(
                        paymentRow.deleteButton
                )
        );
    }

    @When("^User types (\\d+) into card number field$")
    public void user_types_into_card_number_field(String cardNumber) {
        cache.put("cardNumber", cardNumber);
        paymentManagement.cardNumberInput.sendKeys(cardNumber);
    }

    @When("User selects two years from now for the expiration field")
    public void user_selects_two_years_from_now_for_the_expiration_field() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.roll(GregorianCalendar.YEAR, 2);
        StringBuffer buffer = new StringBuffer(); // this should be a helper function
        buffer.append(calendar.get(GregorianCalendar.DATE));
        buffer.append('-');
        buffer.append(calendar.get(GregorianCalendar.MONTH));
        buffer.append('-');
        buffer.append(calendar.get(GregorianCalendar.YEAR));
        cache.put("expiration", buffer.toString());
        paymentManagement.expDateInput.sendKeys(
                buffer.toString()
        );
    }

    @When("^User types (\\d+) into ccv field$")
    public void user_types_into_ccv_field(String ccv) {
        cache.put("ccv", ccv);
        paymentManagement.ccvInput.sendKeys(ccv);
    }

    @When("User clicks the add payment button")
    public void user_clicks_the_add_payment_button() {
        paymentManagement.addPaymentButton.click();
    }

    @Then("The new payment should be visible in the payment-table")
    public void the_new_payment_should_be_visible_in_the_payment_table() {
        wait.until(driver -> {
            WebElement lastRow = paymentTable.rows.get(
                    paymentTable.rows.size() - 1
            );
            PaymentRowModule target = PageFactory.initElements(
                    lastRow,
                    PaymentRowModule.class
            );
            return (
              target.cardNumberTd.getText().equals(
                      (String) cache.get("cardNumber")
              ) &&
              target.ccvTd.getText().equals(
                      (String) cache.get("ccv")
              )
            );
        });
    }

    @When("User clicks the delete payment button")
    public void user_clicks_the_delete_payment_button() {
        // the easiest way to see if something is deleted
        // is to count the total elements before and after deletion
        cache.put(
                "paymentCount",
                paymentTable.rows.size()
        );
        paymentRow.deleteButton.click();
    }

    @Then("The payment should no longer be visible")
    public void the_payment_should_no_longer_be_visible() {
        Integer oldCount = (Integer) cache.get("paymentCount");
        if (paymentTable.rows.size() + 1 != oldCount) {
            throw new AssertionError("no payment was removed");
        }
    }

    @When("User updates first name input")
    public void user_updates_first_name_input() {
        String text = updateProfile.firstNameInput.getAttribute("value");
        StringBuffer deleter = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
            deleter.append(Keys.BACK_SPACE);
        }
        updateProfile.firstNameInput.sendKeys(deleter.toString());
        text = text + "+";
        updateProfile.firstNameInput.sendKeys(text);
        cache.put("firstName", text);
    }

    @When("User updates last name input")
    public void user_updates_last_name_input() {
        String text = updateProfile.lastNameInput.getAttribute("value");
        StringBuffer deleter = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
            deleter.append(Keys.BACK_SPACE);
        }
        updateProfile.lastNameInput.sendKeys(deleter.toString());
        text = text + "+";
        updateProfile.lastNameInput.sendKeys(text);
        cache.put("lastName", text);
    }

    @When("User clicks the update profile button")
    public void user_clicks_the_update_profile_button() {
        updateProfile.updateButton.click();
    }

    @Then("The placeholder for the first name should be updated")
    public void the_placeholder_for_the_first_name_should_be_updated() {
        Assert.assertEquals(
                updateProfile.firstNameInput.getAttribute("value"),
                (String) cache.get("firstName")
        );
    }

    @Then("The placeholder for the second name should be updated")
    public void the_placeholder_for_the_second_name_should_be_updated() {
        Assert.assertEquals(
                updateProfile.lastNameInput.getAttribute("value"),
                (String) cache.get("lastName")
        );
    }

    @When("User sends {string} to new profile password input")
    public void user_sends_to_new_profile_password_input(String newPassword) {
        updateProfile.passwordInput.sendKeys(newPassword);
    }

    @When("User sends {string} to deactivate account input")
    public void user_sends_to_deactivate_account_input(String keyPhrase) {
        deactivateAccount.deactivateInput.sendKeys(keyPhrase);
    }

    @When("User clicks the deactivate account button")
    public void user_clicks_the_deactivate_account_button() {
        deactivateAccount.deactivateButton.click();
    }

}
