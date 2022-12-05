Feature: Create product

  Background:
    Given I am on the sign in page
    When I fill in the email and password fields with valid credentials of an admin
    And I click the sign in button

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

