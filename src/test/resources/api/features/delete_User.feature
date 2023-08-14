@test
Feature: delete Users


  Scenario Outline: Delete User
    Given I have API "<API>"
    When I call method 'DELETE'
    Then I get the response
    Then I verify response code is 204
    Examples:
      | API          |
      | delete_users |