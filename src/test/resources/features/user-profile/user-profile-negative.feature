@user-profile
@user-profile-negative
@selenium
Feature: user-profile-negative

  # credit cards are at least 13 digits log
  # ccv are at least 3 digits long
  # expiration must be in the future
  Scenario Outline: User tries to add payment with insufficient field data
    Given User is logged in with "user-profile@example.com" and "guest"
    Given User is on profile page
    Given User located the payment-management module
    Given User located the payment-table module
    When User types <card number> into card number field
    When User types <expiration> for the expiration field
    When User types <ccv> into ccv field
    When User erroneously clicks the add payment button
    Then The new payment should not be visible in the payment-table

    Examples:
      | card number               | expiration    | ccv   |
      | ""                        | "12-01-2077"  | "117" |
      | "123456789012"            | "12-01-2077"  | "117" |
      | "123456789123456"         | ""            | "117" |
      | "123456789123456"         | "12-01-1999"  | "117" |
      | "123456789123456"         | "12-01-2077"  | ""    |
      | "123456789123456"         | "12-01-2077"  | "11"  |

  Scenario: User tries to deactivate profile with bad key phrase
    Given User is logged in with "user-profile@badkeyphrase.com" and "guest"
    And User is on profile page
    And User located the deactivate-account module
    When User sends "deactivat" to deactivate account input
    And User erroneously clicks the deactivate account button
    And User signs out
    And User is on login page
    Then User is logged in with "user-profile@badkeyphrase.com" and "guest"

  # users accessing areas that require authorization should be redirected to the login page
  Scenario: Unauthenticated User Navigates to Profile Page
    Given User erroneously is on profile page
    Then User redirected to login page
