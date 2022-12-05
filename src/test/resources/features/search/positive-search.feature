@search
Feature: Search for a product

  Scenario Outline: Search for a product
    Given I am on the home page
    When I type <product> in the search field
    And I click the search button
    Then I should see the search results page populated with products related to <product>

    Examples:
      | product        |
      | Headphones     |
      | TeeShirt       |
      | Shopping Bag   |
      | Coat           |
