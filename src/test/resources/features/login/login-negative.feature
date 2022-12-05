@login
Feature: Login Negative
  Given User is on the home page

  Scenario Outline: Invalid User Login
    When User clicks on Sign Up link
    When User types <email> into email field
    When User types <password> into password field
    When User clicks Sign In Button
    Then User will appear on homepage

    Examples:

      |email | password |
      | "noatemail.com"        | "password"    |
      | "nofirstname@test.com" | "Password10!"  |
      | "nolastname@test.com"  | "Password10!"  |
      | "illegalfirst@gm.com"  | "Password10!"  |
      | "illegallast@gm.com"   | "Password10!"  |
      | "nolastname@test.com"  | "Password10!"  |
      | "nonameatall@test.com" | "Password10!"  |
      | ""                     | "Password10!"  |
      | "invalidemailaddress"  | "Password10!"  |
      | "emailused@gmail.com"  | "Password10!"  |
      | "emailused@gmail.com"  | "Password10!"  |
      | "shortpassword@gm.com" | "Pp"          |
      | "lowercasepass@gm.com" | "password"    |
      | "uppercasepass@gm.com" | "PASSWORD"    |
      | "allnumspass@gm.com"   | "133243422"   |
      | "illegalkeys@gm.com"   | "&%$%^$$%^#@" |
      | "nospecialpass@gm.com" | "Password10"  |
      | "nouppercase@gm.com"   | "password10#"  |
      | "nolowercase@gm.com"   | "PASSWORD10!"  |