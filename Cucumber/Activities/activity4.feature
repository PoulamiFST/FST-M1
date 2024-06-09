@activity4
  Feature: data driven test without example

    @loginTest @loginSuccess
    Scenario: Testing with correct data from inputs
      Given the user is on the login page
      When the user enters "admin" and "password"
      And clicks the submit button
      Then get the confirmation test and verify the message as "Welcome Back, admin"


      @loginTest @loginFailure
    Scenario: Testing with incorrect data from inputs
      Given the user is on the login page
      When the user enters "admin" and "password12"
      And clicks the submit button
      Then get the confirmation test and verify the message as "Invalid Credentials"



