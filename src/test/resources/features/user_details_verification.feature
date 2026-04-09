Feature: User details advanced verification

  Scenario: Verify status code and city for a specific user
    Given the API is available
    When I ask for details of user "Leanne Graham"
    Then the response status code should be 200
    And the user should live in "Gwenborough"
    And the user email should be "Sincere@april.biz"

  Scenario Outline: Verify details for multiple users
    Given the user API is available
    When I ask for details of user "<userName>"
    Then the response status code should be 200
    And the user should live in "<city>"
    And the user email should be "<email>"

    Examples:
      | userName      | city          | email             |
      | Leanne Graham | Gwenborough   | Sincere@april.biz |
      | Ervin Howell  | Wisokyburgh   | Shanna@melissa.tv |
      | Clementine Bauch | McKenziehaven | Nathan@yesenia.net |