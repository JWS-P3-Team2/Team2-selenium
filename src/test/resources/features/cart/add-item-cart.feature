@add-cart
Feature: Successfully add items to cart

  Scenario: Guest user can add items to cart from the home page
    Given The user is on the home page
    When The user hovers over a product window
    And The user clicks the cart icon in the product window
    Then The product should be added to the cart

  Scenario: Guest user can add multiple items to cart from the home page
    Given The user is on the home page
    When The user hovers over a product window
    And The user clicks the cart icon in the product window
    And The user hovers over a different product window
    And The user clicks the cart icon in the second product window
    Then Both products should be added to the cart

  Scenario: Logged in user can add items to cart from the home page
    Given The registered user is on the home page
    When The registered user hovers over a product window
    And The registered user clicks the cart icon in the product window
    Then The product should be added to the cart

  Scenario: Logged in user can add multiple items to cart from the home page
    Given The registered user is on the home page
    When The registered user hovers over a product window
    And The registered user clicks the cart icon in the product window
    And The registered user hovers over a different product window
    And The registered user clicks the cart icon in the second product window
    Then Both products should be added to the cart