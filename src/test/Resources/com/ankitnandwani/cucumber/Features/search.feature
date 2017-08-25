Feature: DuckDuckGo Search

  Scenario: Verify Valid Search
    Given I'm at duckduckgo homepage
    When I enter cucumber in search bar
    Then Search results should be displayed

    Scenario: 