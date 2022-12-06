Feature: Create product

  Background:
    Given User is on the home page
    When User clicks on Sign In link
    When User types "admin@example.com" into email field
    When User types "password" into password field
    When User clicks Sign In Button

  Scenario Outline: An admin creates a new product with wrong info
    When User clicks on edit products
    When User clicks create new product
    When User inputs <product name> in product name
    When User inputs <product description> in product description
    When User inputs <product image url> in product url
    When User inputs <product price> in product price
    When User clicks back to products
    Then An error message should appear
    Then The new product should not appear as the latest product

    Examples:

      | product name | product description | product image url | product price |
      | "" | "Admin"      | "anything"       | "111" |
      | "Addy" | ""      | "anything"       | "111" |
      | "Addy" | "Admin"      | ""       | "111" |
      | "Addy" | "Admin"      | "anything"       | "" |
      | "Addy" | "Admin"      | "anything"       | "eeeee" |

