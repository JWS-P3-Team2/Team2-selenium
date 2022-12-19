@cart
Feature: Adjust Quantity of Products in Cart
  Background: User is on home page
    Given User is on the home page

  Scenario: Add Item Number In Cart
    When The user hovers over a product window
    And The user clicks the cart icon in the product window
    When User clicks on cart button
    Then User should see item in cart
    Then User clicks on add button and amounts increase

  Scenario: Remove Item Number In Cart
    When The user hovers over a product window
    And The user clicks the cart icon in the product window
    When User clicks on cart button
    Then User should see item in cart
    When User clicks on add button and amounts increase
    Then User clicks on subtract button and amounts decrease

  Scenario: Remove Item From Cart
    When The user hovers over a product window
    And The user clicks the cart icon in the product window
    When User clicks on cart button
    Then User should see item in cart
    Then User clicks on trash button and product is removed