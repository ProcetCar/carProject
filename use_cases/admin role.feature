Feature: Admin Role

  Scenario: Admin manages products
    When the admin selects the "Manage Products" option
    And the admin adds a new product with the following details:
      | Product Name     | Description        | Price | category | available |
      | Product A        | This is Product A  | 50.00 | Interior |    available | 
    Then the product should be added successfully

    And the admin updates the product "Product A" with the following details:
      | Description        | Price |
      | Updated Description | 60.00 |
    Then the product should be updated successfully

    And the admin deletes the product "Product A"
    Then the product "Product A" should be deleted successfully

  Scenario: Admin manages categories
    When the admin selects the "Manage Categories" option
    And the admin deletes the category "Exterior"
    Then the category should be deleted successfully

  Scenario: Admin manages user accounts
    When the admin selects the "Manage User Accounts" option
    And the admin adds a new user account with the following details:
      | Username  | Email                  | password | type | age |
      | user123  | user@gmail.com        | 12345    | customer | 19 |
    Then the user account should be added successfully

    And the admin updates the user account "user123" with the following details:
      | Email                  |
      | updated@example.com     |
    Then the user account should be updated successfully

    And the admin deletes the user account "user123"
    Then the user account should be deleted successfully
