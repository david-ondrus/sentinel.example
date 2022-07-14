#Author: david.ondrus@3pillarglobal.com
@63
Feature: 63 Swag Labs Add To Cart
  As a customer of Swag Labs, I want to be able to select an item and place it in my cart, so that I have an item in my cart.

  @63A
  Scenario: Add To Cart From Main Page
    Given I login to the Sauce Demo Login Page as StandardUser
		When I click the Add Backpack item
    Then I verify a Shopping Cart Item does exists
    When I click the remove backpack item
    Then I verify a Shopping Cart Item does not exists
  
  @63B
  Scenario: Add To Cart From Product Page
    Given I login to the Sauce Demo Login Page as StandardUser
		When I click the backpack item
    Then I am redirected to the Sauce Demo Product Page
    When I click the add backpack item
    Then I verify a Remove Backpack item does exists