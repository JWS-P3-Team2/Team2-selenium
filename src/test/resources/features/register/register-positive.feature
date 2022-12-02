@register
Feature: Register Positive
  Given: User is on the home page

  Scenario Outline: Valid User Register
    When User clicks on Register link
    When User types <firstname> into firstname field
    When User types <lastname> into lastname field
    When User types <email> into email field
    When User types <password> into password field
    When User clicks Sign Up Button
    Then User will appear on sign in page

    Examples:

      firstname | lastname | email | password |
      | "Addy" | "Admin" |"admin@example.com" | "Password10#" |
      | "Test" | "Testerson" |"test@example.com" | "Password10#" |
      | "Cart" | "Testermill" |"cart-tester@example.com" | "Password10#" |


