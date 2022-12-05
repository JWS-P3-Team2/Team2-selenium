Feature: Create product

  Background:
    When User clicks on Sign In link
    When User types "admin@example.com" into email field
    When User types "password" into password field
    When User clicks Sign In Button

  Scenario Outline: An admin creates a new product
    When User clicks on edit products
    When User clicks create new product
    When User inputs <product name>
    When User inputs <product description>
    When User inputs <product image url>
    When User inputs <product price>
    When User clicks back to products
    Then The new product should appear as the latest product

    Examples:

   | product name | product description | product image url | product price |
      | "Addy" | "Admin"      | "anything"       | "111" |

