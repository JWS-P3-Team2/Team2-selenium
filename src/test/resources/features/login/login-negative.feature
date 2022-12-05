@login
@login-negative
Feature: Login Negative
  Background: User is on the home page
    Given User is on the home page

  Scenario Outline: Invalid User Login
    When User clicks on Sign In link
    When User types <email> into email field
    When User types <password> into password field
    When User clicks Sign In Button
    Then User will appear on homepage

    Examples:

      |email | password |
      | "invalidemailaddress"  | "Password10!"  |
      | "shortpassword@gm.com" | "Pp"          |
      | "lowercasepass@gm.com" | "password"    |
      | "uppercasepass@gm.com" | "PASSWORD"    |
      | "allnumspass@gm.com"   | "133243422"   |
      | "illegalkeys@gm.com"   | "&%$%^$$%^#@" |
      | "nospecialpass@gm.com" | "Password10"  |
      | "nouppercase@gm.com"   | "password10#"  |
      | "nolowercase@gm.com"   | "PASSWORD10!"  |
      | "" | "" |
      | "" | "guest" |
      | "admin@example.com" | ""|