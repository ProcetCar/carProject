Feature: Customer Role

  Background:
    Given the user is on the homepage

  Scenario: Browse Product Categories
    Given the user is logged in as a customer
    When they click on the "Browse Products" option
    Then they should see a list of product categories
    And they can click on a category to view products within that category "Electronics"

  Scenario: View Product Details
    Given the user is browsing product categories
    When they click on a product to view its details
    Then they should see detailed product information

  Scenario: Search and Filter Products
    Given the user is browsing product categories
    When they use the search and filter options "Interior"
    And  the following details:
     | Product Name     | Description        | Price | category | available |
      | Car Seat Cover       | High-quality seat cover for cars  |  49.99 | Interior |    available | 
    Then they should be able to find products matching their ctegory

  Scenario: Make a Purchase
    Given the user is viewing product details "Car Seat Cover"
    When they click on the "Add to Cart" or "Buy Now" button
    Then they should be able to make a purchase 
    
    And they should receive an order confirmation

  Scenario: View Order History
    Given the user has made a purchase
    When they navigate to their profile and click on Ordr History
    
    Then they should see a list of their past orders

  Scenario: Request Installation
    Given the user is viewing product details
    When they click on the "Request Installation" button
    And they provide installation details "Car Seat Cover" and "30/10/2023"
    Then they should be able to submit an installation request
    And they should receive a confirmation of their request

  Scenario: Edit Customer Profile
    When they navigate to their profile "example1@gmail.com"
    And they make changes email "example5@gmail.com"
    And click "Save Changes"
    Then their profile information should be updated successfully

  

