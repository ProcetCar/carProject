Feature: User Login
    Scenario: Exit scenario
    Given I choose to exit instead of log in
    Then i will not enter the app
    
    Scenario: Successful Login
    Given I am on the login page
    When I enter my email as "example1@example.com"
    And I enter my password as "password1"
    Then A login succeded message should appear
    And i will be logged in as a customer
    
     Scenario: Successful Loginn
    Given I am on the login pagee
    When I enter my emaill as "example2@example.com"
    And I enter my passwordd as "password2"
    Then A login succeded message should appearr
    And i will be logged in as a installer
    
     Scenario: Successful Loginnn
    Given I am on the login pageee
    When I enter my emailll as "example3@example.com"
    And I enter my passworddd as "password3"
    Then A login succeded message should appearrr
    And i will be logged in as an adminstrator
    
  
   Scenario: Fail Login
    Given I am on the login page
    When I enter my emaillll as "example@example.com"
    And I enter my passwordddd as "password"
    Then An error message succeded message should appear
    