**Web UI Testing Using Cucumber, Java, Gradle, and Selenium.**

This project is an automated testing framework for Web UI testing using Cucumber, JUnit, and Selenium with Page Object Model (POM) principles. 
With this approach, testing becomes more structured, maintainable, and organized based on the web pages of the application being tested.

**Main Features.**

• Cucumber: Used to write test cases in an easy-to-understand Gherkin format, describing positive, negative, and boundary scenarios.
• Page Object Model (POM): Each web page is represented as a separate Java class for easy management of elements and methods.
• Selenium Chrome Driver: Used for browser automation during testing.
• BaseTest: The main driver configuration is managed in the base class for browser setup and tear-down after testing.
• Utilities: There is a Webhook class to support additional utilities during testing.
• JSON and HTML reports: Test results are presented in JSON and HTML formats that can be analyzed easily.
• Page-based Testing: Tests are organized according to web pages, and the corresponding methods are called via Step Definitions.

**Project Structure**

src/test/java/com/tiks/pages: Folder for Page Object Model implementation. Each web page has its own class for elements and interactions.

src/test/java/com/tiks/stepdef: Folder for CucumberHook files as utilities and for Step Definitions that link Gherkin test cases with POM methods.

src/test/java/com/tiks: Folder for BaseTest class files that set up Selenium WebDriver.

src/test/java/com/tiks: Folder for the CucumberTest file for running Cucumber tests with JUnit.

src/test/resources: Folder for .feature files that describe the test cases in Gherkin format.

build.gradle: Gradle project configuration with all required dependencies.

**Run the Test.**

1. Clone the repository to local
    git clone <repository-url>
    cd <repository-name>
2. Run the test using Gradle
    gradle clean test
3. Once the test is complete, the report will be available in the folder
    JSON: build/reports/cucumber.json
    HTML: build/reports/cucumber-html/index.html

**Example Scenario**

Positive Test: Ensures the function runs with valid input.
Negative Test: Verifies the web with invalid input.
Boundary Test: Tests web behavior at boundary values.

**Example for file .feature:**

Feature: Login 
Scenario: Login with username and password
    Given user is on login page
    When user input username with "standard_user"
    And user input password with "secret_sauce"
    And user clicks login button
    Then user is on homepage  
    
Scenario: Login with username and wrong password
    Given user is on login page
    When user input username with "standard_user"
    And user input password with " "
    And user clicks login button
    Then user able to see error message "Epic sadface: Username and password do not match any user in this service" 
    
**Dependencies**

Here are some of the main dependencies used in this project:
**Cucumber**: For writing and running Gherkin-based tests.
**JUnit**: For running tests with integration to Cucumber.
**Selenium**: For browser interaction automation.
**ChromeDriver**: For running tests in the Chrome browser.

