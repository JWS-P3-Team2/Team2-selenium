@register
Feature: Register Negative
  Background: User is on the home page
    Given User is on the home page

  Scenario Outline: Invalid User Register
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
      | ""      | "Admin" | "nofirstname@test.com" | "Password10!"  |
      | "Addy"  | ""       | "nolastname@test.com"  | "Password10!"  |
      |"21223"  | "Admin" | "illegalfirst@gm.com"  | "Password10!"  |
      |"Addy"  | "244242" | "illegallast@gm.com"   | "Password10!"  |
      | ""      | ""       | "nonameatall@test.com" | "Password10!"  |
      |"Addy"  | "Admin" | ""                     | "Password10!"  |
      |"Addy"  | "Admin" | "invalidemailaddress"  | "Password10!"  |
      |"Addy"  | "Admin" | "shortpassword@gm.com" | "Pp"          |
      |"Addy"  | "Admin" | "lowercasepass@gm.com" | "password10!"    |
      |"Addy"  | "Admin" | "uppercasepass@gm.com" | "PASSWORD"    |
      |"Addy"  | "Admin" | "allnumspass@gm.com"   | "133243422"   |
      |"Addy"  | "Admin" | "illegalkeys@gm.com"   | "&%$%^$$%^#@" |
      |"Addy"  | "Admin" | "nospecialpass@gm.com" | "Password10"  |
      |"Addy"  | "Admin" | "nouppercase@gm.com"   | "password10#"  |
      |"Addy"  | "Admin" | "nolowercase@gm.com"   | "PASSWORD10!"  |


