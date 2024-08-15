Feature: Login page feature

Scenario: Login page title
Given user is in login page
When user gets the title of page
Then title should be "Customer Login"

Scenario: Forgot password link
Given user is in login page
Then user click on forgot password

Scenario: Login the correct credentials
Given user is in login page
When user enters username "naruto.uzumaki@test.com"
And user enters password "Naruto@1234"
And user click on login button
Then user gets the title of page
And title should be "My Account"