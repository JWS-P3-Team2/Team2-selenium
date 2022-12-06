@user-profile
@user-profile-smoke
Feature: user-profile-smoke

  # User located (module-name) module
  # (module-name) module has (tagName) named (name)
  # (module-name) module has (tagName) containing text (text)
  # (module-name) module has (property) /* will work better with page objects */
  Scenario: Viewing Profile Information
    Given User is logged in with "user-profile@example.com" and "guest"
    Given User is on profile page
    Given User located the update-profile module
    Then update-profile module has input named firstName
    Then update-profile module has input named lastName
    Then update-profile module has input named password
    Then update-profile module has button containing text Update
    Given User located the deactivate-account module
    Then deactivate-account has deactivateInput
    Then deactivate-account has deactivateButton
    Given User located the payment-management module
    Then payment-management has cardNumberInput
    Then payment-management has expirationInput
    Then payment-management has ccvInput
    Then payment-management has addButton
    Given User located the payment-table module
    Then payment-table headers contains Card Number
    Then payment-table headers contains Expiration Date
    Then payment-table headers contains CCV
    Then payment-table headers contains Action
    Given User located a payment-row module
    Then payment-row cardNumber
    Then payment-row expirationDate
    Then payment-row ccv
    Then payment-row deleteButton

