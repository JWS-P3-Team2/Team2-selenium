@product
Feature: Update product

  Background:
    Given User is on the home page
    When User clicks on Sign In link
    When User types "admin@example.com" into email field
    When User types "password" into password field
    When User clicks Sign In Button

  Scenario Outline: An admin updates a new product
    When User clicks on edit products
    When User clicks on an existing product
    When User inputs <product name> in product name
    When User inputs <product description> in product description
    When User inputs <product image url> in product url
    When User inputs <product price> in product price
    When User clicks update
    When User clicks back to products
    Then The product should be updated <product name> <product description> <product image url> <product price>

    Examples:

      | product name | product description | product image url | product price |
      | "Addy" | "Admin"      | "anything"       | "111" |

