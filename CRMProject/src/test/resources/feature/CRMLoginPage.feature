Feature: verify CRM Login Page

@Demo1
Scenario Outline: verify crm login with credentails
Given user on the crm login page
When user enter <username> and <password>
Then click on the login button
And verify user on home page


Examples:
|username                 |password|
|studentuser2020@gmail.com|nevergiveup2020|

@Demo2
Scenario: verify crm login the valid credetails
Given user on the crm login page
When user enter login credentails 
|studentuser2020@gmail.com|nevergiveup2020|
Then click on the login button
And verify user on home page


