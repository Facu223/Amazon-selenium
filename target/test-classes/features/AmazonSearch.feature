Feature: Test amazon search and add to cart functionality

	@Test
  Scenario Outline: As a customer whem i search for alexa, i want to see if the third option on the second page is available and can be added to the cart
    Given the user navigates to www.amazon.com
    And searches for <Product>
    And navigates to the second page
    And selects the third item
    Then the user is able to add it to the cart

    					
    Examples: 
      | Product  		|
      | playstation |