@product-details
Feature: display-products

  Scenario Outline: Users should be able to see description of all products
    Given The user is on the home page
    When User clicks on Sign In link
    When User types <email> into email field
    When User types <password> into password field
    When User clicks Sign In Button
    Then The user should review description of all products

    Examples:
      |email | password |
      |"admin@example.com"        | "guest" |
      |"test@example.com"         | "guest" |
      |"cart-tester@example.com"  | "password" |