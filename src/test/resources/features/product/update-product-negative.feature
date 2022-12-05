Feature: Update product

  Background:
    Given I am on the sign in page
    When I fill in the email and password fields with valid credentials of an admin
    And I click the sign in button

  Scenario Outline: An admin updates a new product with incorrect info
    When User clicks on edit products
    When User clicks on an existing product
    When User inputs <product name>
    When User inputs <product description>
    When User inputs <product image url>
    When User inputs <product price>
    When User clicks update
    When User clicks back to products
    Then An error message should appear
    Then The product should be updated

    Examples:

      | product name | product description | product image url | product price |
      | "" | "Admin"      | "anything"       | "111" |
      | "Addy" | ""      | "anything"       | "111" |
      | "Addy" | "Admin"      | ""       | "111" |
      | "Addy" | "Admin"      | "anything"       | "" |
      | "Addy" | "Admin"      | "anything"       | "eeeee" |

