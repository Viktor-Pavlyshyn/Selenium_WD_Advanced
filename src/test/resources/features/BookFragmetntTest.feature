@regression
Feature:
  Scenario: Proceed to checkout, final review and place order as guest user
    Given I am an anonymous customer with clear cookies
    And I open the "Initial home page"
    Then verify that book - "The Midnight Library" in block - "Bestselling Books" have author - "Matt Haig" and add to basket