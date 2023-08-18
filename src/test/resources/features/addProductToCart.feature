Feature: Products Management in SauceDemo
  Scenario: Adding a product to the cart
    Given I am logged in as "standard_user" with password "secret_sauce"
    When I add the product "Sauce Labs Backpack" to the cart
    Then The product "Sauce Labs Backpack" should be in my cart