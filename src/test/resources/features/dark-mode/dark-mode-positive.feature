@dark-mode
Feature: A registered user, guest, or admin can adjust color scheme to normal or dark mode

  Scenario: A registered user, guest, or admin can change from normal to dark mode and vice versa on the home page
    Given The user is logged in and on the home page
    When The user clicks the dark mode checkbox
    Then The screen changes from normal to dark mode
    When The user clicks the dark mode checkbox again
    Then The screen changes from dark mode to normal

  Scenario: The dark mode color scheme is enable for each registered user link on the web page
    Given The user is logged in and on the home page
    When The user clicks the dark mode checkbox
    Then The screen changes from normal to dark mode
    When The user clicks the profile link
    Then The screen is still in dark mode
    When The user clicks the cart link
    Then The screen is still in dark mode

  Scenario: The dark mode color scheme is enable for each guest link on the web page
    Given The user is on the home page
    When The user clicks the dark mode checkbox
    Then The screen changes from normal to dark mode
    When The user clicks the cart link
    Then The screen is still in dark mode