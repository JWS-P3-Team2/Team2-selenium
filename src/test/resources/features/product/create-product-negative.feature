@product
@create-product-negative
Feature: Create product

  Background:
    Given User is on the home page
    When User clicks on Sign In link
    When User types "admin@example.com" into email field
    When User types "guest" into password field
    When User clicks Sign In Button

  Scenario Outline: An admin creates a new product with wrong info
    When User clicks on edit products
    When User clicks create new product on admin product page
    When User inputs <product name> in product name
    When User inputs <product description> in product description
    When User inputs <product image url> in product url
    When User inputs <product price> in product price
    When User clicks create new product on create product page
    When User clicks back to products
    Then The new product should not appear as the latest product

    Examples:

      | product name | product description | product image url | product price |
      | "" | "Admin 1"      | "https://i.insider.com/54eb437f6bb3f7697f85da71?width=1000&format=jpeg&auto=webp"       | "111" |
      | "Addy 1" | ""      | "https://i.insider.com/54eb437f6bb3f7697f85da71?width=1000&format=jpeg&auto=webp"       | "112" |
      | "Addy 2" | "Admin 2"      | ""       | "113" |
      | "Addy 3" | "Admin 3"      | "https://i.insider.com/54eb437f6bb3f7697f85da71?width=1000&format=jpeg&auto=webp"       | "" |
      | "Addy 4" | "Admin 4"      | "https://i.insider.com/54eb437f6bb3f7697f85da71?width=1000&format=jpeg&auto=webp"       | "eeeee" |

