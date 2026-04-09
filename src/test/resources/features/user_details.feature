Feature: User Management

  Scenario: Verify user geographic location
    Given the user API is available
    When I request details for user "Clementina DuBuque"
    Then the user latitude should be less than 0.0
    And the user city should be "Lebsackbury"