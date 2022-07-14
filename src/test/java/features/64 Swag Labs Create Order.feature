#Author: david.ondrus@3pillarglobal.com
@64
Feature: 64 Swag Labs Create Order
  As a customer of Swag Labs, I want to be able to select an item, 
  go to my cart and order my item

  @64A
  Scenario: Create order on backapck
    Given I login to the Sauce Demo Login Page as StandardUser
		When I click the Add Backpack item
      And I click a Shopping Cart Item
    Then I am redirected to the Sauce Demo Cart Page
    When I click the Checkout button
    Then I am redirected to the Sauce Demo Checkout Step One Page
    When I enter John in the First Name
    	And I enter Doe in the Last Name
    	And I enter 1234 in the Zip code
    	And I click the Continue button
    Then I am redirected to the Sauce Demo Checkout Step Two Page
    When I click the Finish button
    Then I am redirected to the Sauce Demo Checkout Complete Page
    	And I verify the Header contains the text "THANK YOU FOR YOUR ORDER"
  
    
    