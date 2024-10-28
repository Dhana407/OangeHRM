@SmokeFeature
Feature: OrangeHRM login

  @smoketest
  Scenario: OrangeHRM login with valid data
    Given open browser
    When enter the url of the OrangeHRM
    Then homepage is displayed
    When enter the username and password
    And click on login
    Then dashboard will displayed
    And close browser
