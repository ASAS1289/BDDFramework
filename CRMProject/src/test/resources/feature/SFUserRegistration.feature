Feature: verify user registration funcationality
@Usercreation
Scenario: verifying user registration with valid information
Given user is on signup page
When user enters firstname last name email role comapny country postalcode and username
When user click on checkbox
Then user click on signupsubmit