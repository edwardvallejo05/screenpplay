Feature: Login into the application

  Scenario: Login Successfull with Standard User
    Given Pepito has an active account
    When he sends their valid credentials
    Then he should have access to the store