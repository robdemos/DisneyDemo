Feature: Adding items to the shopping cart

  Scenario: Add a Mickey Mouse hat to the cart
    Given A user visits the disney store
    And searches for a mickey mouse hat
    And adds one to the cart
    Then the hat should be the only item in the cart