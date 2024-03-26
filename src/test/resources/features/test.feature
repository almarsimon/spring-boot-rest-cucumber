Feature: REST API should work

  Scenario: Client makes a call to GET /version
    When the client calls the URL "/version"
    Then the client receives status code of 200
    And  the client receives a string response of "v1.0.0"