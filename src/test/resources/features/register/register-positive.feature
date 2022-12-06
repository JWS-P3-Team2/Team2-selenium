@register
@register-positive
Feature: Register Positive
  Background: User is on the home page
    Given User is on the home page

  Scenario Outline: Valid User Register
    When User clicks on Register link
    When User types <firstname> into firstname field
    When User types <lastname> into lastname field
    When User types <email> into email registration field
    When User types <password> into password registration field
    When User clicks Sign Up Button
    When User waits for log in page
    When User types <email> into email field
    When User types <password> into password field
    When User clicks Sign In Button
    Then User should click on Profile link
    Then User should see <firstname> in greeting

    Examples:

      |firstname | lastname | email | password |
      | "Addy" | "Admin" |"admin@new-register.com" | "Password10#" |
      | "Test" | "Testerson" |"test@new-register.com" | "Password10#" |
      | "Cart" | "Testermill" |"cart-tester@example.com" | "Password10#" |


