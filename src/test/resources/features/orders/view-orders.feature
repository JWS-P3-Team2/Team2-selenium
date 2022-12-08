@orders
Feature: View Orders

  Background: User is on homepage
  Given User is on the home page

  Scenario Outline: View Orders
    When User clicks on Sign In link
    When User types <email> into email field
    When User types <password> into password field
    When User clicks Sign In Button
    When User will click on Orders
    Then User will see all orders purchased and view details

    Examples:
  | email | password |
  | "revieworders@example.com" | "Review10!" |