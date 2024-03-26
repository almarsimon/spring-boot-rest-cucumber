Feature: Version API should work

  Scenario: client makes call to GET /employees
    When the client calls "/employees"
    Then the client receives status code of 200
    And  the client receives a string response of "v1.0.0"