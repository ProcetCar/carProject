Feature: add product

Scenario: add product

Given the admin is logged in and has access to the system

When the admin adds a new product with the following information:

| Product Name     | Description        | Price | category | available |
| Product A        | This is Product A  | 50.00 | Interior |    available | 
Then the product should be added 