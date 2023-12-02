Feature: Send Email
  Scenario: order complete
    When order is complete
    Then Send email

  Scenario: order is not complete
    When order isn't complete
    Then Send email order not complete
    
  