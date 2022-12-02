@checkout
Feature: Checkout

  Background: User is on the checkout page with items in their cart
    Given The user is on the home page
    When The user adds an item to their cart
    When The user goes to their cart
  Scenario Outline: User checks out
    When The user clicks checkout now
    When The user inputs <firstname>
    When The user inputs <lastname>
    When The user inputs <addressLine1>
    When The user inputs <city>
    When The user inputs <zip>
    When The user inputs <state>
    When The user inputs <country>
    When The user clicks next
    When The user selects their payment option
    When The user clicks submit payment
    When The user clicks place  order
    Then The item the user bought should be removed from the inventory


    Examples:
      | firstname   | lastname | addressLine1    | city   | zip     | state | country|
      | "gator"     | "chomp"  | "Manager" | "Patty"  | "12345"  | "Patty"  | "Pastiche"  |
