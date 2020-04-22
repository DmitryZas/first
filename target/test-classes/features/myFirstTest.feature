Feature: my first feature

  Scenario Outline: Test seed generator
    Given A rest api request with parameters: "<seed_id>"
    When I make request with specified seed
    Then I receive response with name: "<name>"
    And I receive response with last name: "<second_name>"
    Examples:
      | seed_id          | name     |second_name |
      | 9fc04b1b42d9ec36 | Dawn     | Byrd       |
      | 3b0a75273d3ceb15 | Conradus | Hartog     |
      | 32c1f7c2c9457397 | Xenia    | Simon      |
      | 9d3ef4d56a52fe43 | Matthew  | Smith      |