@MerchantwarriorTest @Shrido
Feature: Merchantwarrior Tests  
This feature includes Merchantwarrior tests using RESTFul services

  Background:
  Given The User sets the base URL as "https://api.merchantwarrior.com" for Merchant

	Scenario: TC-01 Verify Card
	When The User sends a POST request for Merchantwarrior with the request body from "Verify_Card.json" and captures the response body
	Then The response code for Merchantwarrior should be "200"
	And The response body for Merchantwarrior should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |

  Scenario: TC-02 Change Expiry Of Card
	When The User sends a POST request for Merchantwarrior with the request body from "Change Expiry Of Card.json" and captures the response body
	Then The response code for Merchantwarrior should be "200"
	And The response body for Merchantwarrior should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |

  Scenario: TC-03 Remove Card Merchant warrior
	When The User sends a POST request for Merchantwarrior with the request body from "Remove Card Merchant warrior.json" and captures the response body
	Then The response code for Merchantwarrior should be "200"
	And The response body for Merchantwarrior should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  
  Scenario: TC-04 Verify card
	When The User sends a POST request for Merchantwarrior with the request body from "Verify card.json" and captures the response body
	Then The response code for Merchantwarrior should be "200"
	And The response body for Merchantwarrior should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  
  Scenario: TC-05 Get Card INfo
	When The User sends a POST request for Merchantwarrior with the request body from "Get Card Info.json" and captures the response body
	Then The response code for Merchantwarrior should be "200"
	And The response body for Merchantwarrior should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  
  Scenario: TC-06 New Request
	When The User sends a POST request for Merchantwarrior with the request body from "New Request.json" and captures the response body
	Then The response code for Merchantwarrior should be "200"
	And The response body for Merchantwarrior should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |

