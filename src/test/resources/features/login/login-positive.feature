@login
  Feature: Login Positive

  Background: User is on the home page
    Given User is on the home page

  Scenario Outline: Valid User Logins
    When User clicks on Sign In link
    When User types <email> into email field
    When User types <password> into password field
    When User clicks Sign In Button
    Then User should click on Profile link
    Then User should see <firstname> in greeting

    Examples:

    |email | password | firstname |
    |"admin@example.com"        | "password" |"Addy"|
    |"testexample.com"          | "password" |"Testy"|
    |"cart-tester@example.com"  | "password" |"Carty"|


