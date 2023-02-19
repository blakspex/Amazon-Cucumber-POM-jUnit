Feature: Home page feature

Scenario: Home page title
Given user is on Home page
When user gets the title of the page
Then the page title should be "Amazon.com. Spend less. Smile more."

Scenario: User sign in status
Given user is on Amazon page
When user is not signed in
And user tries to access cart
And user clicks on Proceed to Buy
Then user must be asked to sign in

#Scenario: Check for broken links
#Given user is on Home page
#When response for all links are checked
#Then all links should return response code 200
