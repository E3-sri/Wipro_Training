@Checkout
Feature: checkout Functionality 

  Scenario Outline: Checkout after items added to cart.
    Given User is logged with username "<username>" and password "<passwordKey>"
    When User clicks on the product and adds it to cart
    Then User navigates to the cart and clicks on checkout
    When User fills checkout details with "<firstname>" "<lastname>" "<postalcode>"
    And User clicks on continue
    And User clicks on finish
    Then User should see the confirmation message "Thank you for your order!"
    When User click on BackToHome button user should be navigated to home page

 Examples: 
  | browser | username                    | passwordKey | firstname | lastname | postalcode |
  | edge    | standard_user               | password    | John      | Doe      | 12345      |
  | edge    | performance_glitch_user     | password    |           |          |            |
  | edge    | visual_user                 | password    | @@@       | $$$      | !!!        |
  | edge    | performance_glitch_user     | password    | @@@       | ###      | @3$%       |
  | edge    | performance_glitch_user     | password    | 123456    | 123578   | @3$%       |


  
  
 Scenario Outline: Checkout after adding multiple products
    Given User is logged with username "<username>" and password "<password>"
    When User adds multiple products to the cart
    And User navigates to the cart and clicks on checkout
    And User fills checkout details with "<firstname>" "<lastname>" "<postalcode>"
    And User clicks on continue
    And User clicks on finish
    Then User should see the confirmation message "Thank you for your order!"
    When User click on BackToHome button user should be navigated to home page


  Examples: 
    | browser | username      | password     | firstname | lastname | postalcode | Status |
    | edge    | standard_user | password     | John      | Doe      | 12345      | Pass   |
    | edge    | visual_user   | password     | Jane      | smith    | 67890      | pass   |
    
    
    
 


