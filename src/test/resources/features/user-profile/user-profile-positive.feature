@user-profile
@user-profile-positive
@selenium
Feature: user-profile-positive
# should probably include a background clause
  Scenario: Adding Credit Card to Profile
    Given User is logged in with "user-profile@example.com" and "guest"
    Given User is on profile page
    Given User located the payment-management module
    When User types 4444333322221111 into card number field
    When User selects two years from now for the expiration field
    When User types 000 into ccv field
    When User clicks the add payment button
    Given User located the payment-table module
    Then The new payment should be visible in the payment-table

  Scenario: Deleting a Credit Credit Card from Profile
    Given User is logged in with "user-profile@example.com" and "guest"
    Given User is on profile page
    Given User located the payment-management module
    Given User located the payment-table module
    Given User located a payment-row module
    When User clicks the delete payment button
    Then The payment should no longer be visible

  Scenario: Updating Profiles Full Name
    Given User is logged in with "user-profile@example.com" and "guest"
    Given User is on profile page
    Given User located the update-profile module
    When User updates first name input
    And User updates last name input
    And User clicks the update profile button
    And User refreshes the page
    Given User is on profile page
    Given User located the update-profile module
    Then The placeholder for the first name should be updated
    And The placeholder for the second name should be updated

  Scenario: Updating Profile Password
    Given User is logged in with "user-profile@onetime.com" and "guest"
    And User is on profile page
    And User located the update-profile module
    When User sends "new password" to new profile password input
    And User clicks the update profile button
    And User signs out
    Then User is logged in with "user-profile@onetime.com" and "new password"

  Scenario: Deactivating User Profile
    Given User is logged in with "user-profile@tobedeactivated.com" and "guest"
    And User is on profile page
    And User located the deactivate-account module
    When User sends "deactivate" to deactivate account input
    And User clicks the deactivate account button
    Then User is on login page
    Then User cannot login with "user-profile@tobedeactivated.com" and "guest"
