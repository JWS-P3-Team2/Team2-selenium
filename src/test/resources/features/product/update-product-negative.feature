Feature: Update product

  Background:
    Given User is on the home page
    When User clicks on Sign In link
    When User types "admin@example.com" into email field
    When User types "password" into password field
    When User clicks Sign In Button

  Scenario Outline: An admin updates a new product with incorrect info
    When User clicks on edit products
    When User clicks on an existing product
    When User inputs <product name> in product name on the update page
    When User inputs <product description> in product description on the update page
    When User inputs <product image url> in product url on the update page
    When User inputs <product price> in product price on the update page
    When User clicks update
    When User clicks back to products
    Then An error message should appear
    Then The product should not be updated

    Examples:

      | product name | product description | product image url | product price |
      | "" | "Admin"      | "anything"       | "111" |
      | "Addy" | ""      | "anything"       | "111" |
      | "Addy" | "Admin"      | ""       | "111" |
      | "Addy" | "Admin"      | "anything"       | "" |
      | "Addy" | "Admin"      | "anything"       | "eeeee" |

