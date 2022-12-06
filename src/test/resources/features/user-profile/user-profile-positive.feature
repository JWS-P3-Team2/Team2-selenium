@user-profile
@user-profile-positive
Feature: user-profile-positive
# should probably include a background clause
  Scenario: Adding Credit Card to Profile
    Given User is logged in
    Given User is on profile page
    Given User located the payment-management module
    When User types 4444333322221111 into card number field
    When User selects two years from now for the expiration field
    When User types 000 into ccv field
    When User clicks the add payment button
    Given User located the payment-table module
    Then The new payment should be visible in the payment-table

  Scenario: Deleting a Credit Credit Card from Profile
    Given User is logged in
    Given User is on profile page
    Given User located the payment-management module
    Given User located the payment-table module
    Given User located a payment-row module
    When User clicks the delete payment button
    Then The payment should no longer be visible

  Scenario: Updating Profiles Full Name
    Given User is logged in

  Scenario: Updating Profile Password
    Given User is logged in

  Scenario: Deactivating User Profile
    Given User is logged in
