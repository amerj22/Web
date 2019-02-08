Feature: right count value displayed on the screen 

Background: 
	Given user navagets to value page 
	When user is on the balance sheet 
	
@test 
Scenario: Verify the right count of values appear on the screen 
	Then user should be able to see "count" 
	
@test 
Scenario: Verify the total sum of values is equale to total balance 
	Then the sum of all values are equal to total sum 
	
Scenario: verify values are in Currancy format 
    Then values are in currancy format