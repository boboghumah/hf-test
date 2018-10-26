Feature: Check Out  
	To ensure that existing users can checkout successfully 
	
Scenario: To ensure that existing users can checkout successfully 
	Given User navigates to the website. 
	And User clicks on the sign in button on the homepage. 
	And User enters a valid email address on the log in form. 
	And User enters a valid password on the log in form. 
	And User clicks on the sign in buttonon the login form
	And User selects a product 
	And User clicks on the Add to cart button 
	And User click on the Proceed to checkout button
	And User click on the Proceed to checkout button on the Cart Summary page
	And User click on the Proceed to checkout button on the Address page 
	And User checks the Terms Of Service checkbox
	And User click on the Proceed to checkout button on the Shipping page 
	And User selects Pay by bank wire payment method 
	When User clicks on the I confirm my order button 
	Then User should be redirected an Order Confirmation page successfully     
	
	

