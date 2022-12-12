@checkout
Feature: Checkout

  Background: User is on the checkout page with items in their cart
    Given The User has logged in
    Given Products are visible
    Given The user has added an item to their cart
  Scenario Outline: User checks out
    When The user clicks the checkout button from the cart link
    When The user inputs <firstname> into the firstname field
    When The user inputs <lastname> into the lastname field
    When The user inputs <addressLine> into the addressLine field
    When The user inputs <city> into the city field
    When The user inputs <zip> into the zip field
    When The user inputs <state> into the state field
    When The user inputs <country> into the country field
    When The user clicks next
    And The user selects a payment method
    And The user clicks the submit payment button
    And The user clicks the place order button
    When User is on the home page
    Then The item the user bought should be removed from the inventory


    Examples:
      | firstname   | lastname | addressLine    | city   | zip     | state | country|
      | "gator"     | "chomp"  | "Manager" | "Patty"  | "12345"  | "Patty"  | "Pastiche"  |
