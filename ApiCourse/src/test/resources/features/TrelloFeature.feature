Feature: This feature tests trello API

  Scenario: Add a new list to the test board after changing title
    Given The board exists and contains the correct information
    When I change the board title to "This is changed"
    And I check that the board title was updated to "This is changed"
    Then I add a list with title "This is a list" to the board