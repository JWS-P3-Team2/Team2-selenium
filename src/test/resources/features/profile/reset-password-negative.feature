@reset-password
Feature: Reset Password
Given User is on the home page
When User clicks on Sign Up link
When User types "testexample.com"  into email field
When User types "password" into password field
When User clicks Sign In Button

  Scenario Outline: User changes their password with an invalid new one
    When User clicks on profile link
    When User types <newpassword> into password field
    When User clicks update Button
    Then A message should appear stating the update has been unsuccessful

    Examples:

      |newpassword |
      |""     |
      |"1"     |
      |"12345"     |
      |"123e!"     |
      |"12345612345678eE$12345678eE$12345678eE$12345678eE$12345678eE$12345678eE$12345678eE$12345678eE$12345678eE$78eE$"     |


