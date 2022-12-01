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
      | "Corey" | "Miller" |"cmiller241gmail.com"   | "password"    |
      | ""      | "Miller" | "nofirstname@test.com" | "Password10!"  |
      |"Corey"  | ""       | "nolastname@test.com"  | "Password10!"  |
      |"21223"  | "Miller" | "illegalfirst@gm.com"  | "Password10!"  |
      |"Corey"  | "244242" | "illegallast@gm.com"   | "Password10!"  |
      |"Corey"  | ""       | "nolastname@test.com"  | "Password10!"  |
      | ""      | ""       | "nonameatall@test.com" | "Password10!"  |
      |"Corey"  | "Miller" | ""                     | "Password10!"  |
      |"Corey"  | "Miller" | "invalidemailaddress"  | "Password10!"  |
      |"Corey"  | "Miller" | "emailused@gmail.com"  | "Password10!"  |
      |"Corey"  | "Miller" | "emailused@gmail.com"  | "Password10!"  |
      |"Corey"  | "Miller" | "shortpassword@gm.com" | "Pp"          |
      |"Corey"  | "Miller" | "lowercasepass@gm.com" | "password"    |
      |"Corey"  | "Miller" | "uppercasepass@gm.com" | "PASSWORD"    |
      |"Corey"  | "Miller" | "allnumspass@gm.com"   | "133243422"   |
      |"Corey"  | "Miller" | "illegalkeys@gm.com"   | "&%$%^$$%^#@" |
      |"Corey"  | "Miller" | "nospecialpass@gm.com" | "Password10"  |
      |"Corey"  | "Miller" | "nouppercase@gm.com"   | "password10#"  |
      |"Corey"  | "Miller" | "nolowercase@gm.com"   | "PASSWORD10!"  |


