@orders
Feature: View Orders

  Background: User is on homepage
  Given User is on the home page

  Scenario Outline: View Orders
    When User clicks on Register link
    When User types <firstname> into firstname field
    When User types <lastname> into lastname field
    When User types <email> into email field
    When User types <password> into password field
    When User clicks Sign Up Button
    Then User will appear on sign in page
    When User types <email> into email field
    When User types <password> into password field
    When User clicks Sign In Button
    When User clicks on first item cart button
    When User clicks on cart button
    Then User should see item in cart
    Then User should buy item in cart (a lot going on here)
    When User will click on Orders
    Then User will see all order purchased and view details

    Examples:
  | firstname | lastname | email | password |
  | "Corey" | "Miller" |"goodorders@gmail.com" | "Orders10!" |