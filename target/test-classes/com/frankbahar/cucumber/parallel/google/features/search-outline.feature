Feature: Searching on Google using Scenario Outline

  Scenario Outline: Search Google from Scenario Outline
    
    Given launch browser '<browserName>'
    When user navigates to '<url>'
    Then user enters search term '<search>'
    And clicks on search button

    Examples:
		|browserName|url									 |search|
		|chrome			|https://www.google.com|Cucumber|
		|firefox		|https://www.google.com|Selenium|