@user-profile
@user-profile-negative
@pending
Feature: user-profile-negative

  Scenario: User Adds a Payment with Invalid Credit Card Number
    Given User is logged in
    Given Scenario is incomplete

  Scenario: User Adds a Payment with an Invalid CCV
    Given User is logged in
    Given Scenario is incomplete

  Scenario: User Adds an Expired Payment
    Given User is logged in
    Given Scenario is incomplete

  Scenario: User Updates Profile with Invalid Username
    Given User is logged in
    Given Scenario is incomplete

  Scenario: Unauthenticated User Navigates to Profile Page
    Given User is on the homepage
    Given Scenario is incomplete
