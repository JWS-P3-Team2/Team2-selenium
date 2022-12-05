@login
Feature: Add Cart
  Given User is on the home page

  Scenario: Add Item To Cart
    When User clicks on first item cart button
    When User clicks on cart button
    Then User should see item in cart

  Scenario: Add Item Number In Cart
    When User clicks on first item cart button
    When User clicks on cart button
    Then User should see item in cart
    When User clicks on add button
    Then item amount number and price increases

  Scenario: Remove Item Number In Cart
    When User clicks on first item cart button
    When User clicks on cart button
    Then User should see item in cart
    When User clicks on add button
    Then item amount number and price increases
    When User clicks on subtract button
    Then item amount number and price decreases

  Scenario: Remove Item From Cart
    When User clicks on first item cart button
    When User clicks on cart button
    Then User should see item in cart
    When User clicks on trash button
    Then item should be removed from page