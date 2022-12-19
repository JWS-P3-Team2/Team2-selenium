@product-reviews
Feature: Leave a review for a product, delete a review

  # This scenario should pass
  Scenario: Leave a review for a product on product modal
    Given I am on the sign in page
    When I fill in the email and password fields with valid credentials
    And I click the sign in button
    Then I should be on the home page
    Given I am on the product review page
    When I click the product link
    Then I should see the product modal
    When I click on a rating
    And I fill in the review field with "This is a review"
    And I click the submit button on the modal
    Then I should see the review under product reviews with "This is a review"

  # This scenario should fail
  Scenario: Leave a review for a product on product page
    Given I am on the sign in page
    When I fill in the email and password fields with valid credentials
    And I click the sign in button
    Then I should be on the home page
    Given I am on the product review page
    When I click on a product
    Then I should see the product modal
    When I click the product details link
    Then I should see the product details page
    When I click on a rating
    And I fill in the review field with "This is a review"
    And I click the submit button on the modal
    Then I should see the review under product reviews with "This is a review"

  # This scenario should pass
  Scenario: Leave a review for a product that has a review with same user
    Given I am on the sign in page
    When I fill in the email and password fields with valid credentials
    And I click the sign in button
    Then I should be on the home page
    Given I am on the product review page
    When I click the product link
    Then I should see the product modal
    When I click on a rating
    And I fill in the review field with "This is another review"
    And I click the submit button on the modal
    Then I should not see the review under product reviews with "This is another review"

  # This scenario should pass
  Scenario: Delete a review for a product
    Given I am on the sign in page
    When I fill in the email and password fields with valid credentials
    And I click the sign in button
    Then I should be on the home page
    Given I am on the product review page
    When I click the product link
    Then I should see the product modal
    When I click the delete button on the review
    Then I should see no reviews under product reviews

