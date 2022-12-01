@login
Feature: Login Negative
  Given: User is on the home page

  Scenario Outline: Invalid User Login
    When User clicks on Sign Up link
    When User types <email> into email field
    When User types <password> into password field
    When User clicks Sign In Button
    Then User will appear on homepage

    Examples:

      |email | password |
      |"cmiller241@gmail.com" | "fakepassword" |
      |"whatever" | "whatever" |
