Feature: Login into the application

  Scenario: Login unsuccessful empty Credentials
    Given Edward has not credentials
    When he dit not send their valid credentials
    Then he should have not access to the store

  Scenario: Login unsuccessful empty field User
    Given Edward has not valid credentials
    When he dit not send their user name
    Then he should to be visible alert Username is requiered

  Scenario: Login unsuccessful empty field Password
    Given Edward has not an active password
    When he dit not send their password
    Then he should to be visible alert Password is requiered

  Scenario: Login Successfull with Standard User
    Given Edward has an active account
    When he sends their valid credentials
    Then he should have access to the store

  Scenario: Login unsuccessful with User locked
    Given Edward has an locked account
    When he sends their blocked account
    Then he should to be visible alert user has been locked

  Scenario: Login successful with Problem user
    Given Edward has an active with Problems
    When he logs in and adds a product to the shopping cart
    Then he could not remove the product

  Scenario: Add Product with Standard User
    Given Edward has an active session
    When Add a Product to Cart
    Then he should see the product in the shopping Cart

  Scenario: Pay a Purchase with Standard User
    Given Edward wants to buy a Product
    When add a product to the cart and pay for it
    Then he should see the order confirmation
