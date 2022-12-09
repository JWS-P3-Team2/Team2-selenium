@checkout
Feature: Checkout

  Background: User is on the checkout page with items in their cart
    Given The User has logged in
    Given Products are visible
    Given The user has added an item to their cart
  Scenario Outline: User checks out but doesn't input the right data in their address
    When The user clicks the checkout button from the cart link
    When The user inputs <firstname> into the firstname field
    When The user inputs <lastname> into the lastname field
    When The user inputs <addressLine> into the addressLine field
    When The user inputs <city> into the city field
    When The user inputs <zip> into the zip field
    When The user inputs <state> into the state field
    When The user inputs <country> into the country field
    When The user clicks next
    Then Then an error message should appear
    Then The user should still be on shipping address

    Examples:
      | firstname   | lastname | addressLine    | city   | zip     | state | country|
      | "1"     | "chomp"  | "Manager" | "Patty"  | "12345"  | "Patty"  | "Pastiche"  |
      | "chomp"     | "1"  | "Manager" | "Patty"  | "12345"  | "Patty"  | "Pastiche"  |
      | "chomp"     | "chomp"  | "Manager" | "1"  | "12345"  | "Patty"  | "Pastiche"  |
      | "chomp"     | "chomp"  | "Manager" | "Patty"  | "12345"  | "Patty"  | "1"  |
      | "chomp"     | "chomp"  | "Manager" | "Patty"  | "12345"  | "1"  | "Pastiche"  |
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
