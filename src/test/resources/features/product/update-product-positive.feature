@product

Feature: Update product

  Background:
    Given User is on the home page
    When User clicks on Sign In link
    When User types "admin@example.com" into email field
    When User types "guest" into password field
    When User clicks Sign In Button

  Scenario Outline: An admin updates a new product
    When User clicks on edit products
    When User clicks on an existing product
    When User inputs <product name> in product name on the update page
    When User inputs <product description> in product description on the update page
    When User inputs <product image url> in product url on the update page
    When User inputs <product price> in product price on the update page
    When User clicks update
    When User clicks back to products
    Then The product should be updated <product name> <product description> <product image url> <product price>

    Examples:

      | product name | product description | product image url | product price |
      | "Addy2" | "Admin2"      | "https://i.insider.com/54eb437f6bb3f7697f85da71?width=1000&format=jpeg&auto=webp"       | "1111" |

