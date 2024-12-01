Feature: Login

#  positive-login-case
  @LoginRequired
  Scenario: Login with username and password
    Given user is on login page
    When user input username with "standard_user"
    And user input password with "secret_sauce"
    And user clicks login button
    Then user is on homepage

#    negative-login-case
  @LoginRequired
  Scenario: Login with username and wrong password
    Given user is on login page
    When user input username with "standard_user"
    And user input password with " "
    And user clicks login button
    Then user able to see error message "Epic sadface: Username and password do not match any user in this service"

#    boundaries-login-case
  @LoginRequired
  Scenario: Login with username and without password
    Given user is on login page
    When user input username with "standard_user"
    And user input password with ""
    And user clicks login button
    Then user able to see error message "Epic sadface: Password is required"