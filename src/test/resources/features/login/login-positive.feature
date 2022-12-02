@login
  Feature: Login Positive
    Given: User is on the home page

  Scenario Outline: Valid User Logins
    When User clicks on Sign Up link
    When User types <email> into email field
    When User types <password> into password field
    When User clicks Sign In Button
    Then User will appear on homepage

    Examples:

    |email | password |
    |"admin@example.com"        | "password" |
    |"testexample.com"          | "password" |
    |"cart-tester@example.com"  | "password" |


