Feature: Checkout

  Scenario: Validate user can use checkout button
    Given user has added "Sauce Labs Backpack" to the cart
    And user clicks cart icon
    And user is on cart page
    When user clicks checkout button
    Then user will redirect to form shipping address

  Scenario: Filling in shipping address form for proceeding to the next step
    Given user is on form shipping address page
    When user input first name with "Yu"
    And user input last name with "Christian"
    And user input zip code with "40374"
    And user clicks continue button
    Then user will redirect to finishing page

  Scenario: Proceeding to the next step without filling in last name
    Given user is on form shipping address page
    When user input first name with "TaehyungTeajus"
    And user input last name with ""
    And user input zip code with "40374"
    And user clicks continue button
    Then user will see error message "Error: Last Name is required"

  Scenario: Validate user has completed checkout
    Given user has completed all checkout step
    And user is on checkout overview page
    When user clicks finish button
    Then checkout is complete