@Cart
Feature: Cart Page Functionality

 Scenario Outline: Checking whether the Functionalities in the cart page are working properly or not
    Given User with username "<username>" and password "<passwordKey>" with "<browser>" browser
    When User clicks on the add to cart button of the product
    Then Product should be added to cart
    And Count of the cart should be increased
    When User clicks on remove button
    Then product should be removed from cart
    And decrease the count of cart
    When User clicks on continue shopping button
    Then User should be navigated back to products page
    
     Examples:
    | username      | passwordKey     | browser |
    | visual_user   | password        | edge    |
    
  Scenario Outline: Add and verify multiple products in the cart
    Given User is logged into SauceDemo with username "<username>" and password "<passwordKey>" with "<browser>" browser
    When User adds multiple products to cart
    Then Cart should display all selected products
    And Cart count should match number of added products
    
     Examples:
    | username      | passwordKey     | browser |
    | standard_user | password        | edge    |
    
       
  Scenario Outline: Checkout attempt with empty cart
    Given User is logged into SauceDemo with username "<username>" and password "<passwordKey>" with "<browser>" browser
    When User navigates to cart without adding products
    And User clicks on checkout
    Then System should not proceed to checkout
    And Error or empty cart message should be displayed
    
     Examples:
    | username      | passwordKey     | browser |
    | visual_user   | password        | edge    |
    
  
     
