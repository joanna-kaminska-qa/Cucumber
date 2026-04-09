Feature: User Management

  Scenario Outline: Verify user geographic location
    Given the user API is available
    When I request details for user "<userName>"
    Then the user latitude should be less than <latLimit>
    And the user city should be "<expectedCity>"

    Examples:
          | userName           | latLimit | expectedCity  |
          | Clementina DuBuque | 0.0      | Lebsackbury  |
          | Leanne Graham      | 100.0    | Gwenborough  |
          | Ervin Howell       | 0.0      | Wisokyburgh  |