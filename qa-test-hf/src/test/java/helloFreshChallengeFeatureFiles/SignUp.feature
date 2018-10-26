Feature: Sign Up 
	To ensure that a New user can Sign Up Successfully 
	
Scenario: To ensure that a New user can Sign Up Successfully 
	Given User navigates to the website 
	And User clicks on the sign in button on the homepage 
	And User enters a valid email address 
	And User clicks the create an account button 
	And User selects title 
	And User enters firstname 
	And User enters lastname 
	And User enters a valid password 
	And User selects date of birth 
	And User enters company name 
	And User enters company address 
	And User enters city 
	And User selects state 
	And User enters postcode 
	And User enters additional information 
	And User enters phonenumber 
	And User enters an address alias 
	When User clicks on the register button 
	Then User should be redirected to the homepage successfully    
	
	
