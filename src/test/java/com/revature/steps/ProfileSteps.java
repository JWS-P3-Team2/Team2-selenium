package com.revature.steps;

import com.revature.MainRunner;
import com.revature.modules.*;
import com.revature.pages.ProfilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.reporters.jq.Main;

import java.util.*;
import java.util.stream.Collectors;


public class ProfileSteps {

    @Given("User is on profile page")
    public void user_is_on_profile_page() {
        MainRunner.driver.get(MainRunner.profileUrl);
        MainRunner.wait.until(ExpectedConditions.urlToBe(MainRunner.profileUrl));
    }

    @Given("User located the update-profile module")
    public void user_located_the_update_profile_module() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        page.getUpdateProfile();
    }

    @Then("update-profile module has input named firstName")
    public void update_profile_module_has_input_named_first_name() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        page.getUpdateProfile().get("firstName");
    }

    @Then("update-profile module has input named lastName")
    public void update_profile_module_has_input_named_last_name() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        page.getUpdateProfile().get("lastName");
    }

    @Then("update-profile module has input named password")
    public void update_profile_module_has_input_named_password() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        page.getUpdateProfile().get("password");
    }

    @Then("update-profile module has button containing text Update")
    public void update_profile_module_has_button_containing_text_update() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        WebElement button = page.getUpdateProfile().submit;
    }

    @Given("User located the deactivate-account module")
    public void user_located_the_deactivate_account_module() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        page.getDeactivateAccount();
    }

    @Then("deactivate-account has deactivateInput")
    public void deactivate_account_has_deactivate_input() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        page.getDeactivateAccount().get("Deactivate");
    }

    @Then("deactivate-account has deactivateButton")
    public void deactivate_account_has_deactivate_button() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        WebElement button = page.getDeactivateAccount().submit;
    }

    @Given("User located the payment-management module")
    public void user_located_the_payment_management_module() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        page.getPaymentManagement();
    }

    @Then("payment-management has cardNumberInput")
    public void payment_management_has_card_number_input() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        page.getPaymentManagement().get("cardNumber");
    }

    @Then("payment-management has expirationInput")
    public void payment_management_has_expiration_input() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        page.getPaymentManagement().get("expDate");
    }

    @Then("payment-management has ccvInput")
    public void payment_management_has_ccv_input() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        page.getPaymentManagement().get("ccv");
    }

    @Then("payment-management has addButton")
    public void payment_management_has_add_button() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        WebElement button = page.getPaymentManagement().submit;
    }

    @Given("User located the payment-table module")
    public void user_located_the_payment_table_module() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        page.getPaymentManagement().getPaymentTable();
    }

    @Then("^payment-table headers contains (.+)$")
    public void payment_table_headers_contains(String heading) {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        PaymentTableModule paymentTable = page
                .getPaymentManagement()
                .getPaymentTable();
        List<String> paymentHeaderText = paymentTable.headers.stream().map(
                element -> element.getText()
        ).collect(Collectors.toList());
        paymentHeaderText.contains(heading);
    }

    @Given("User located a payment-row module")
    public void user_located_a_payment_row_module() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        PaymentRowModule row = page
                .getPaymentManagement()
                .getPaymentTable()
                .getPaymentRows()
                .get(0);
    }

    @Then("payment-row has deleteButton")
    public void payment_row_delete_button() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        PaymentRowModule row = page
                .getPaymentManagement()
                .getPaymentTable()
                .getPaymentRows()
                .get(0);
        WebElement button = row.deleteButton;
    }

    @When("^User types (\\d+) into card number field$")
    public void user_types_into_card_number_field(String cardNumber) {
        MainRunner.cache.put("cardNumber", cardNumber);
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        page.getPaymentManagement().get(
                "cardNumber"
        ).sendKeys(cardNumber);
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
        MainRunner.cache.put("expiration", buffer.toString());
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        page.getPaymentManagement().get(
                "expDate"
        ).sendKeys(buffer.toString());
    }

    @When("^User types (\\d+) into ccv field$")
    public void user_types_into_ccv_field(String ccv) {
        MainRunner.cache.put("ccv", ccv);
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        page.getPaymentManagement().get(
                "ccv"
        ).sendKeys(ccv);
    }

    @When("User clicks the add payment button")
    public void user_clicks_the_add_payment_button() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        page.getPaymentManagement().submit.click();
    }

    @Then("The new payment should be visible in the payment-table")
    public void the_new_payment_should_be_visible_in_the_payment_table() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        PaymentTableModule table = page.getPaymentManagement().getPaymentTable();
        MainRunner.wait.until(driver -> {
            PaymentRowModule last = table.getPaymentRows().get(
                    table.getPaymentRows().size() - 1
            );
            return (
              last.data.get(0).getText().equals(
                      (String) MainRunner.cache.get("cardNumber")
              ) &&
              last.data.get(2).getText().equals(
                      (String) MainRunner.cache.get("ccv")
              )
            );
        });
    }

    @When("User clicks the delete payment button")
    public void user_clicks_the_delete_payment_button() {
        // the easiest way to see if something is deleted
        // is to count the total elements before and after deletion
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
       List<PaymentRowModule> rows = page
               .getPaymentManagement()
               .getPaymentTable()
               .getPaymentRows();
        MainRunner.cache.put(
                "paymentCount",
                rows.size()
        );
        // for some reason this may take more than one click
        WebElement button = rows.get(0).deleteButton;
        button.click();
    }

    @Then("The payment should no longer be visible")
    public void the_payment_should_no_longer_be_visible() {
        Integer oldCount = (Integer) MainRunner.cache.get("paymentCount");
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        List<PaymentRowModule> rows = page
                .getPaymentManagement()
                .getPaymentTable()
                .getPaymentRows();
        try {
            MainRunner.wait.until(driver -> {
                // will move on when one payment option goes missing
                return rows.size() + 1 == oldCount;
            });
        }
        catch (TimeoutException e) {
            throw new AssertionError(
    "payment would would not delete, implementation appears to be spotty"
            );
        }
    }

    @When("User updates first name input")
    public void user_updates_first_name_input() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        WebElement input = page.getUpdateProfile().get("firstName");
        String text = input.getAttribute("value");
        StringBuffer deleter = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
            deleter.append(Keys.BACK_SPACE);
        }
        input.sendKeys(deleter.toString()); // should be helper function
        text = text + "+";
        input.sendKeys(text);
        MainRunner.cache.put("firstName", text);
    }

    @When("User updates last name input")
    public void user_updates_last_name_input() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        WebElement input = page.getUpdateProfile().get("lastName");
        String text = input.getAttribute("value");
        StringBuffer deleter = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
            deleter.append(Keys.BACK_SPACE);
        }
        input.sendKeys(deleter.toString()); // should be helper function
        text = text + "+";
        input.sendKeys(text);
        MainRunner.cache.put("lastName", text);
    }

    @When("User clicks the update profile button")
    public void user_clicks_the_update_profile_button() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        page.getUpdateProfile().submit.click();
    }

    @Then("The placeholder for the first name should be updated")
    public void the_placeholder_for_the_first_name_should_be_updated() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        WebElement input = page.getUpdateProfile().get("firstName");
        Assert.assertEquals(
                input.getAttribute("value"),
                (String) MainRunner.cache.get("firstName")
        );
    }

    @Then("The placeholder for the second name should be updated")
    public void the_placeholder_for_the_second_name_should_be_updated() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        WebElement input = page.getUpdateProfile().get("lastName");
        Assert.assertEquals(
                input.getAttribute("value"),
                (String) MainRunner.cache.get("lastName")
        );
    }

    @When("User sends {string} to new profile password input")
    public void user_sends_to_new_profile_password_input(String newPassword) {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        WebElement input = page.getUpdateProfile().get("password");
        input.sendKeys(newPassword);
    }

    @When("User sends {string} to deactivate account input")
    public void user_sends_to_deactivate_account_input(String keyPhrase) {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        WebElement input = page.getDeactivateAccount().get("Deactivate");
        input.sendKeys(keyPhrase);
    }

    @When("User clicks the deactivate account button")
    public void user_clicks_the_deactivate_account_button() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        page.getDeactivateAccount().submit.click();
    }

    @When("User erroneously clicks the deactivate account button")
    public void user_erroneously_clicks_the_deactivate_account_button() {
        try {
            user_clicks_the_deactivate_account_button();
        }
        catch (ElementClickInterceptedException e) {
            // it is okay if this click is intercepted
        }
    }

    @When("User types {string} into card number field")
    public void alt_user_types_into_card_number_field(String cardNumber) {
        user_types_into_card_number_field(cardNumber);
    }
    @When("User types {string} for the expiration field")
    public void user_types_for_the_expiration_field(String expDate) {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        page.getUpdateProfile().get("expDate").sendKeys(expDate);
    }
    @When("User types {string} into ccv field")
    public void alt_user_types_into_ccv_field(String ccv) {
        user_types_into_ccv_field(ccv);
    }
    @When("User erroneously clicks the add payment button")
    public void user_erroneously_clicks_the_add_payment_button() {
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        PaymentManagementModule form = page.getPaymentManagement();
        MainRunner.cache.put(
                "paymentCount",
                form.getPaymentTable().rows.size()
        );
        form.submit.click();
    }
    @Then("The new payment should not be visible in the payment-table")
    public void the_new_payment_should_not_be_visible_in_the_payment_table() {
        Integer oldCount = (Integer) MainRunner.cache.get("paymentCount");
        ProfilePage page = PageFactory.initElements(
                MainRunner.driver,
                ProfilePage.class
        );
        List<WebElement> rows = page
                .getPaymentManagement()
                .getPaymentTable()
                .rows;
        try {
            // will throw an AssertionError if a payment is added
            MainRunner.wait.until(driver -> {
                return oldCount + 1 == rows.size();
            });
            throw new AssertionError(
                    "an invalid payment was created"
            );
        }
        catch (TimeoutException e) {
            // no payment was created, proceed
        }
    }

}
