Feature: Leave a review for a product

  Scenario: Leave a review for a product
    Given I am on the sign in page
    When I fill in the email and password fields with valid credentials
    And I click the sign in button
    Then I should be on the home page
    When I click the product link
    Then I should see the product modal
    When I click the leave a review link
    Then I should be on the leave a review page
    When I fill in the review form with valid data
