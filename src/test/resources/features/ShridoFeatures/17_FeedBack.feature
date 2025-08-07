@Shrido
Feature: FeedBack Tests  
This feature includes FeedBack tests using RESTFul services

	Background:
	Given The User sets the base URL as "https://api-staging.shrido.com.au" for User

	Scenario: TC-01 Add FeedBack
	When The User sends a POST request for FeedBack with the request body from "Add FeedBack.json" and captures the response body
	Then The response code for FeedBack should be "200"
	And The response body for FeedBack should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  | message | Thanks for your feedback!     |
  

  

