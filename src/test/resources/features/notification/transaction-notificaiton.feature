Feature: A user should receive a notification when a transaction occurred

  Scenario: Notification following transaction
    Given The user has added an item to their cart
    When The user clicks the checkout button from the cart link
    And The user fills out the shipping information
    And The user clicks next
    And The user selects a payment method
    And The user clicks the submit payment button
    And The user clicks the place order button
    Then The user should receive a notification indicating that a transaction occurred.