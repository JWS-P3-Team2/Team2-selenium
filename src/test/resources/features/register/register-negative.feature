@register
Feature: Register Negative
  Given: User is on the home page

  Scenario Outline: Invalid User Register
    When User clicks on Register link
    When User types <firstname> into firstname field
    When User types <lastname> into lastname field
    When User types <email> into email field
    When User types <password> into password field
    When User clicks Sign Up Button
    Then User will appear on sign in page

    Examples:
    firstname | lastname | email | password |
      | "Addy" | "Admin"   | "admin@example.com"   | "password"    |
      | ""      | "Admin" | "nofirstname@test.com" | "Password10!"  |
      | "Addy"  | ""       | "nolastname@test.com"  | "Password10!"  |
      |"21223"  | "Admin" | "illegalfirst@gm.com"  | "Password10!"  |
      |"Addy"  | "244242" | "illegallast@gm.com"   | "Password10!"  |
      |"Addy"  | ""       | "nolastname@test.com"  | "Password10!"  |
      | ""      | ""       | "nonameatall@test.com" | "Password10!"  |
      |"Addy"  | "Admin" | ""                     | "Password10!"  |
      |"Addy"  | "Admin" | "invalidemailaddress"  | "Password10!"  |
      |"Addy"  | "Admin" | "emailused@gmail.com"  | "Password10!"  |
      |"Addy"  | "Admin" | "emailused@gmail.com"  | "Password10!"  |
      |"Addy"  | "Admin" | "shortpassword@gm.com" | "Pp"          |
      |"Addy"  | "Admin" | "lowercasepass@gm.com" | "password"    |
      |"Addy"  | "Admin" | "uppercasepass@gm.com" | "PASSWORD"    |
      |"Addy"  | "Admin" | "allnumspass@gm.com"   | "133243422"   |
      |"Addy"  | "Admin" | "illegalkeys@gm.com"   | "&%$%^$$%^#@" |
      |"Addy"  | "Admin" | "nospecialpass@gm.com" | "Password10"  |
      |"Addy"  | "Admin" | "nouppercase@gm.com"   | "password10#"  |
      |"Addy"  | "Admin" | "nolowercase@gm.com"   | "PASSWORD10!"  |


