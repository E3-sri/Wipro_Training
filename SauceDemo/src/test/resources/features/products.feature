@Products
Feature: Product Page Functionality

  Scenario Outline: To check whether the functionalities in product page is working fine or not
    Given User is logged into SauceDemo with username "<username>" and password "<passwordKey>"
    And User is on home page now
    When User clicks on filter option
    And try to choose the option in dropdown
    Then Products should be arranged according to that
    When User click on the particular product
    And Product should be opened
	When User clicks randomly on a social media icon
    Then it should route to particular site
    When Product is opened
    And User should have a option to add the product to cart
    When User clicks on back to home button
    Then User should be navigated back to the Products Page
       
    Examples:
    | username         | passwordKey     |
    | standard_user    | password        |

  Scenario Outline: Verify all products are listed
    Given User is logged into SauceDemo with username "<username>" and password "<passwordKey>"
    And User is on home page now
    Then User should see all products listed
    
      Examples:
    | username      | passwordKey     |
    | problem_user  | password        |

  Scenario Outline: Verify products remain after page refresh
    Given User is logged into SauceDemo with username "<username>" and password "<passwordKey>"
    And User is on home page now
    When User refreshes the product page
    Then Products should still be visible

  Examples:
    | username      | passwordKey     |
    | error_user    | password        |
    
  Scenario Outline: User logs out successfully
    Given User is logged into SauceDemo with username "<username>" and password "<passwordKey>"
    When User click on icon left side bar for logout
    And click on logout button
    Then User should be navigated back to login page

    Examples:
      | username      | passwordKey     |
      | standard_user | password        |
      | visual_user   | password        |

  
