@activity5
Feature: data driven test without example


  Scenario: Testing with Data from Scenario
    Given the user is on the login page
    When the user enters "<Usernames>" and "<Passwords>"
    And clicks the submit button
    Then Read the page title and confirmation message
    Examples:
      | Usernames | Passwords |
      | admin     | password  |
      | adminUser | Password  |