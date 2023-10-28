Feature: User Signup 

  Scenario: Successful Signup 
    Given I am on the signup page
    When I enter a valid username as a  "ali"
    And I enter a valid password as a "password4"
    And I enter a valid email as a "example4@gmail.com"
    And I enter a valid age as a "20"
    Then I should be registered successfully

  Scenario: user Already Registered
    Given a user is already registered
    When I enter the same email "example1@gmail.com"
    And I click the signup button
    Then I should see an error message for a user already registered

  Scenario: Missing Username
    Given I am on the signup page
    When I enter a username as a ""
    And I enter a valid password as a "password4"
    And I enter a valid email as a "example4@gmail.com"
   And I enter a valid age as a "19"
    And I click the signup button
    Then I should see an error message for a missing username

  Scenario: Missing Password
    Given I am on the signup page
    When I enter a username as a "ali"
    And I enter a  password as a ""
    And I enter a valid email as a "example4@gmail.com"
   And I enter a valid age as a "19"
    And I click the signup button
    Then I should see an error message for a missing password


  Scenario: missing Email
     Given I am on the signup page
    When I enter a username as a "ali"
    And I enter a valid password as a "password4"
    And I enter a valid email as a ""
   And I enter a valid age as a "19"
    And I click the signup button
    Then I should see an error message for a missing email


  Scenario: missing Age
     Given I am on the signup page
    When I enter a username as a "ali"
    And I enter a valid password as a "password4"
    And I enter a valid email as a "example4@gmail.com"
   And I enter a valid age as a ""
    And I click the signup button
    Then I should see an error message for a missing age
    
    Scenario: invalid email
    Given I am on the signup page
    When i enter a invalid email "example.com"
    And I click the signup button
    Then I should see an error message for a ivalid email
    
