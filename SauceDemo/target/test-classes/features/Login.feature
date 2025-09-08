Feature: Login Functionality
Scenario Outline: Login With Different Credentials
  Given User is on the login page
  When User enters username "<username>"
  And User enters password "<passwordKey>"
  And click on login button
  Then user navigated to home page
  And user verify the login result

  
  Examples:
  | username                | passwordKey     |
  | standard_user           | password        |
  | Sree                    | wrongPassword   |
  | error_user              | blankPassword   |
  |                         | blankPassword    |
  | problem_user            | password        |
  | performance_glitch_user | password        |
  | invalid_user            | password        |
  | @@@                     | invalidPassword |
  | user                    | wrongPassword   |
