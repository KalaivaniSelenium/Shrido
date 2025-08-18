@PaymentsTest @Shrido
Feature: Payments Tests  
This feature includes Payments tests using RESTFul services

  Background:
	Given The User sets the base URL as "https://api-staging.shrido.com.au" for Payment
	
	@CreatePayment
	Scenario: TC-01 Create Payment
	When The User sends a POST request for Payments with the request body from "Create Payment.json" and captures the response body
	Then The response code for Payments should be "202"
	And The response body for Payments should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 202                           |
  | status  | true                          |
  | message | Your wallet has been credited with 1000 points. Enjoy your rides with Shrido!    |
  
  @Verifyreceipt
	Scenario: TC-02 Verify receipt
	When The User sends a POST request for Payments with the request body from "Verify receipt.json" and captures the response body
	Then The response code for Payments should be "200"
	And The response body for Payments should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
 
  @VerifySubscription
	Scenario: TC-03 Verify Subscription
	When The User sends a POST request for Payments with the request body from "Verify Subscription.json" and captures the response body
	Then The response code for Payments should be "200"
	And The response body for Payments should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |

  