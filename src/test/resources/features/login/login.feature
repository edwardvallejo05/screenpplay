Feature: Login into the application

  Scenario: Login Successfull with Standard User
    Given User has an active account
    When he sends their valid Credencials
    Then he should have access to the store