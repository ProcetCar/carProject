Feature: Installation Requests

  Scenario: Customer requests installation for a product
    Given the customer wants to request installation services
    When they fill out the installation request form
      | Productid         |   customerid            | orderid   |email              | city   | street|
      | 1                 |   1                      | 1         |example1@gmail.com | nablus |rafidia|
    Then the request should be submitted successfully

  Scenario: Installer checks availability and schedules appointment
    Given the installer is available for appointments
    When they review the installation requests
    And they schedule an appointment for the customer
    Then the appointment should be confirmed



  Scenario: Installer not available
    Given the installer is not available for appointments
    When they fill out the installation requests form
        | Productid         |   customerid            | orderid   |email              | city   | street|
      | 3                |   1                      | 1         |example1@gmail.com | nablus |rafidia|
    When they review the installation requests
    Then the appointment should be canceled
    
  
