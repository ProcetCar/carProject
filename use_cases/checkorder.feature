Feature: check order

Scenario: order is available
    When order is available
    Then change state "coniformed"
Scenario: order not available
    When order not available
    Then change state order "canceled"
    
    
    
    