@notification
Feature: A user should receive a notification when a transaction occurred

  Scenario: Notification following transaction
    Given The User has logged in
    Given The user has added an item to their cart
    When The user clicks the checkout button from the cart link
    And The user enters a First name
    And The user enters a Last name
    And The user enters an Address
    And The user enters a city
    And The user enters a State Province or Region
    And The user enters a Zip or Postal code
    And The user enters a Country
    And The user clicks next
    And The user selects a payment method
    And The user clicks the submit payment button
    And The user clicks the place order button
    Then The user should receive a notification indicating that a transaction occurred.