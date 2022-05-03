Feature: Application Login

Scenario: Login to the site
Given User is on a login page
When User input login "yura" and password "321"
And click on the loggin button
Then Home page prepopulated "true"
And user name is displayed

Scenario: Login to the site wit incorrect credentals
Given User is on a login page
When User input login "john" and password "231"
And click on the loggin button
Then Home page prepopulated "false"
And user name is displayed