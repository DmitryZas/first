Feature: homework selenium test

  Scenario: Selenium test
    Given Load the page google.com
    When I search facebook account by search button
    Then Validate string in search values

  Scenario: Selenium test 2
    Given Load the page google.com
    When Open Google menu
    Then Check that opened page was Google Maps