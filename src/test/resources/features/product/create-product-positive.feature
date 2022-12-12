@product
@create-product-positive
Feature: Create product

  Background:
    Given User is on the home page
    When User clicks on Sign In link
    When User types "admin@example.com" into email field
    When User types "guest" into password field
    When User clicks Sign In Button

  Scenario Outline: An admin creates a new product
    When User clicks on edit products
    When User clicks create new product on admin product page
    When User inputs <product name> in product name
    When User inputs <product description> in product description
    When User inputs <product image url> in product url
    When User inputs <product price> in product price
    When User clicks create new product on create product page
    When User clicks back to products
    Then The new product should appear as the latest product <product name> <product description> <product image url> <product price>

    Examples:

   | product name | product description | product image url | product price |
      | "Addy" | "Admin"      | "https://i.insider.com/54eb437f6bb3f7697f85da71?width=1000&format=jpeg&auto=webp"       | "111" |

