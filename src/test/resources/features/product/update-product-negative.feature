@product
@update-product-negative
Feature: Update product

  Background:
    Given User is on the home page
    When User clicks on Sign In link
    When User types "admin@example.com" into email field
    When User types "guest" into password field
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
    Then The product should not be updated <product name> <product description> <product image url> <product price>

    Examples:

      | product name | product description | product image url | product price |
      | "" | "Admin 1"      | "anything 1"       | "1" |
      | "Addy 2" | ""      | "anything 2"       | "2" |
      | "Addy 3" | "Admin 3"      | ""       | "3" |
      | "Addy 4" | "Admin 4"      | "anything 4"       | "" |
      | "" | ""      | ""       | "" |
      | "Addy 5" | "Admin 5"      | "anything 5"       | "eeeee" |

