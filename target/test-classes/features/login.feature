Feature: Login into SauceDemo

  Scenario: Successful Login with valid credentials
    Given I am on the SauceDemo login page
    When I login with username "standard_user" and password "secret_sauce"
    Then I should be redirected to the inventory page

  Scenario: Unsuccessful Login with invalid credentials
    Given I am on the SauceDemo login page
    When I login with username "invalid_user" and password "invalid_password"
    Then I should see an error message