@checkout
Feature: Checkout

  Background: User is on the checkout page with items in their cart
    Given The user is on the home page
    When The user adds an item to their cart
    When The user goes to their cart
  Scenario Outline: User checks out but doesn't input the right data in their address
    When The user clicks checkout now
    When The user inputs <firstname>
    When The user inputs <lastname>
    When The user inputs <addressLine1>
    When The user inputs <city>
    When The user inputs <zip>
    When The user inputs <state>
    When The user inputs <country>
    When The user clicks next
    Then Then an error message should appear


    Examples:
      | firstname   | lastname | addressLine1    | city   | zip     | state | country|
      | ""     | "chomp"  | "Manager" | "Patty"  | "12345"  | "Patty"  | "Pastiche"  |
      | "gator"     | ""  | "Manager" | "Patty"  | "12345"  | "Patty"  | "Pastiche"  |
      | "gator"     | "chomp"  | "" | "Patty"  | "12345"  | "Patty"  | "Pastiche"  |
      | "gator"     | "chomp"  | "Manager" | ""  | "12345"  | "Patty"  | "Pastiche"  |
      | "gator"     | "chomp"  | "Manager" | "Patty"  | ""  | "Patty"  | "Pastiche"  |
      | "gator"     | "chomp"  | "Manager" | "Patty"  | "12345"  | ""  | "Pastiche"  |
      | "gator"     | "chomp"  | "Manager" | "Patty"  | "12345"  | "Patty"  | ""  |
      | "gator"     | "chomp"  | "Manager" | "Patty"  | "eee"  | "Patty"  | "Pastiche"  |
      | "gator"     | "chomp"  | "Manager" | "Patty"  | "123456"  | "Patty"  | "Pastiche"  |
      | "gator"     | "chomp"  | "Manager" | "Patty"  | "1234"  | "Patty"  | "Pastiche"  |
