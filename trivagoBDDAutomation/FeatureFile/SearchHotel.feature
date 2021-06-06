Feature: Search 

Scenario: user Search for a Hotels and other stay on weekend page by applying search criteria 

Given     User is on Weekend page 
When      User enters Location 
And       User selects Radius 
And       User selects Dates
And       User clicks on Guest Tab and modifies no. of Guests 
Then      Search results are updated based on Location, Radius, Date and Guest
Then      User clicks on View Deal button