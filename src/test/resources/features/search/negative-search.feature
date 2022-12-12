@search
Feature: Search for a product

    Scenario Outline: Search for a product with no results
    Given I am currently on the home page
    When I type "<random>" in the search field
    And I click the search button
    Then I should see no results

    Examples:
    | random                              |
    | blah                                |
    | 42                                  |
    | David                               |

    Scenario: Try to use script injection in the search field
    Given I am currently on the home page
    When I type "<script>alert('XSS');</script>" in the search field
    And I click the search button
    Then I should see no alert