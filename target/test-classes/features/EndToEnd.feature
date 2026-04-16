Feature: EndToEnd ecommerce 


Scenario: EndToEnd 
	Given user is on login page 
	When user enters data from excel and logs in 
	When user adds a product to cart 
	When user proceeds to checkout 
	When user enters checkout details 
	And user enter payment details from json 
	Then Order is placed successfully