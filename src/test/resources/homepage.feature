Feature: Home

  Scenario: Sorting products by high to low price
    Given user is on home page
    When user clicks sort dropdown
    And user selects "Price (low to high)"
    Then the products on homepage sorted by descending price

  Scenario: Adding product to the cart
    Given user is on home page
    When user clicks add to cart on "Sauce Labs Backpack"
    Then product added to the cart and cart icon shows "1"

  Scenario: Validate cart displays correct list of items
    Given user is on home page
    When user clicks add to cart on "Sauce Labs Backpack"
    And user clicks add to cart on "Sauce Labs Bike Light"
    And user clicks cart icon
    And user redirect to cart page
    Then cart displays the correct list of items
      |Sauce Labs Backpack|
      | Sauce Labs Bike Light|

  Scenario: Validate specific item information
    Given user is on home page
    When user clicks on the "Sauce Labs Bike Light" title
    Then item details is displayed "Sauce Labs Bike Light"