Feature: User creation with DocStrings

  Scenario: Successfully create a new user
    Given the user API is available
    When I send a POST request to "/users" with body:
      """
      {
        "name": "Joanna Tester",
        "username": "joanna_t",
        "email": "joanna@test.com"
      }
      """
    Then the creation status code should be 201

  Scenario Outline: Create multiple users using outline and docstrings
      Given the user API is available
      When I send a POST request to "/users" with body:
        """
        {
          "name": "<name>",
          "username": "<username>",
          "email": "<email>"
        }
        """
      Then the creation status code should be 201

      Examples:
        | name           | username  | email              |
        | Jan Kowalski   | jankow    | jan@kowalski.pl    |
        | Anna Nowak     | annan     | anna@nowak.pl      |
        | Robert Tester  | robtest   | robert@tester.com  |