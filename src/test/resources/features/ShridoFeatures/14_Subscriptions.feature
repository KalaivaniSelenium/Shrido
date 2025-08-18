@SubscriptionsTest  @Shrido
Feature: Subscriptions Tests  
This feature includes Subscriptions tests using RESTFul services

	Background:
	Given The User sets the base URL as "https://api-staging.shrido.com.au" for Subscriptions
	
  Scenario: TC-01 Get All Subscription Plans

	When The User sends a GET request for Subscriptions API from "Get All Subscription Plans" and captures the response body
	Then The response code for Subscriptions should be "200"
	And The response body for Subscriptions should contain the following key-value pairs:
  | Key     | Value                             |
  | code    | 200                               |
  | status  | true                              |
  | message | All Subscription plans.           |
	
	Scenario: TC-02 Add Subscribe plans
	When The User sends a POST request for Subscriptions with the request body from "Add Subscribe plans.json" and captures the response body
	Then The response code for Subscriptions should be "200"
	And The response body for Subscriptions should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
	

  Scenario: TC-03 Edit Subscription plan
  When The User sends a PUT request for Subscriptions with the request body from "Edit Subscription plan.json" and captures the response body
  Then The response code for Subscriptions should be "200"
	And The response body for Subscriptions should contain the following key-value pairs:
  | Key     | Value                                  |
  | code    | 200                                    |
  | status  | true                                   |
  

 
 