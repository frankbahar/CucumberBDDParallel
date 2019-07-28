Feature: Searching on Google

Scenario: Direct search on Google firefox
Given launch browser 'firefox'
When user navigates to 'https://www.google.com'
Then user enters search term 'Cucumber'
And clicks on search button

Scenario: Direct search on Google chrome
Given launch browser 'chrome'
When user navigates to 'https://www.google.com'
Then user enters search term 'Test NG'
And clicks on search button