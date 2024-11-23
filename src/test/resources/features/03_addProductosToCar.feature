Feature: Add products to car
@addProducts
  Scenario: As a user I want to add products to the cart
    Given As a user I navigate to the website
    When As a user I want to log in with username "enlaceOperativo" and password "enlaceOperativo1234"
  And Add the following products to your cart
    | Samsung galaxy s6 |
    | Nokia lumia 1520  |
    | Sony xperia z5    |
    | HTC One M9        |
  Then the user should see the products in the cart
    | Samsung galaxy s6 |
    | Nokia lumia 1520  |
    | Sony xperia z5    |
    | HTC One M9        |
  And The total amount of the products should match the sum of their prices
