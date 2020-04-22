Feature: selenium test

  Scenario: Selenium test
    Given Load page google.com
    When I search for "twitter"
    Then I see "Твиттер. Здесь говорят о том, что происходит." in search results