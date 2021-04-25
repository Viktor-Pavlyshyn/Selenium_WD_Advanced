Feature:
  Scenario: Proceed to checkout, final review and place order as guest user
    Given I am an anonymous customer with clear cookies
    And I open the "Initial home page"
    Then verify author name - "Matt Haig" in block - "Bestselling Books" with book - "The Midnight Library" and click add button