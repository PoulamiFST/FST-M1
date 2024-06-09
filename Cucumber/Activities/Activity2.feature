@activity2
Feature: Activity to test the login feature

  @loginTest
  Scenario: Successful login test
    Given the user is on the login page
    When the user enters username and password
    And clicks the submit button
    Then get the confirmation test and verify the message
