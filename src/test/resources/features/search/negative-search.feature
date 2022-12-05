@search
Feature: Search for a product

    Scenario Outline: Search for a product with no results
    Given I am on the home page
    When I type <random> in the search field
    And I click the search button
    Then I should see no results

    Examples:
    | random                              |
    | blah                                |
    | 42                                  |
    | <script>console.log("xss")</script> |
    | David                               |