@product-reviews
Feature: Leave a review for a product

  Scenario: Leave a review for a product when not signed in
    Given I am on the home page
    When I click the product link
    Then I should see the product modal
    When I click the leave a review link
    Then I should be on the leave a review page
    When I fill in the review form with valid data
    And I click the submit button
    Then I should not be able to submit the form

  Scenario: Leave a review for a product without a rating
    Given I am on the sign in page
    When I fill in the email and password fields with valid credentials
    And I click the sign in button
    Then I should be on the home page
    When I click the product link
    Then I should see the product modal
    When I click the leave a review link
    Then I should be on the leave a review page
    When I fill in the review form with valid data
    And I click the submit button
    Then I should not be able to submit the form

    Scenario: Leave a review for a product without a comment
    Given I am on the sign in page
    When I fill in the email and password fields with valid credentials
    And I click the sign in button
    Then I should be on the home page
    When I click the product link
    Then I should see the product modal
    When I click the leave a review link
    Then I should be on the leave a review page
    When I click on a rating
    And I click the submit button
    Then I should not be able to submit the form

    Scenario: Leave a review for a product with a comment that is too long
    Given I am on the sign in page
    When I fill in the email and password fields with valid credentials
    And I click the sign in button
    Then I should be on the home page
    When I click the product link
    Then I should see the product modal
    When I click the leave a review link
    Then I should be on the leave a review page
    When I fill click on a rating
    And I fill in the comment field with a comment that is too long
    And I click the submit button
    Then I should not be able to submit the form

