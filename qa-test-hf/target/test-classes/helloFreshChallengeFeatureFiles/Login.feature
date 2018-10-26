Feature: Log In 
	To ensure that an Existing user can Log In to the application successfully 
	
Scenario: To ensure that an Existing user can Log In to the application successfully 
	Given User goes to the website 
	And User navigates to the login page by clicking the sign in button on the homepage 
	And User enters a valid email address on the log in form 
	And User enters a valid password on the log in form  
	When User clicks on the sign in button   
	Then User should be signed in and taken to the homepage successfully    
	
	 
	