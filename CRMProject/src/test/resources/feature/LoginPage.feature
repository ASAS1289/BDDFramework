Feature: verify login fucntionality

@smoke
Scenario: verify SF login with valid credentails
Given user is on the sfapplication login page
When user enters username and password
Then user click on the login button

