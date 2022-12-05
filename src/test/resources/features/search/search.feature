Feature: Search for a product

  Scenario: Search for a product
    Given I am on the home page
    When I type "headphones" in the search field
    And I click the search button
    Then I should see the search results page populated with products related to "headphones"

    Scenario: Search for a product with no results
    Given I am on the home page
    When I type "blah" in the search field
    And I click the search button
    Then I should see no results