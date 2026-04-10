Feature: Bulk user operations

  Scenario: Create users from data table
    Given the user API is available
    When I create the following users:
      | name           | username  | email              |
      | Marek Mostowiak| mareczek  | marek@grabina.pl   |
      | Hanka Karton   | hanka     | hanka@mosty.pl     |
    Then they should be successfully processed

  Scenario: Manual mapping example
      When I create users manually from this table:
        | name  | email            |
        | Karol | karol@test.pl    |
        | Anna  | anna@test.pl     |