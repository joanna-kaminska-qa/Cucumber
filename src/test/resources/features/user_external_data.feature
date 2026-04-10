Feature: User creation with external data files
  W tej części testujemy, jak wczytywać duże zestawy danych z plików JSON,
  zamiast wpisywać wszystko ręcznie w scenariuszu.

  Scenario: Create multiple users from a JSON file
    Given the user API is available
    When I load users from "users.json" and create them
    Then they should be successfully processed