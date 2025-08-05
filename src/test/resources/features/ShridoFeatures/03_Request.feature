@RequestTest  @Shrido
Feature: Request Tests  
This feature includes Request tests using RESTFul services

	Background:
	Given The User sets the base URL as "https://api-staging.shrido.com.au" for User
	
	@SendtripRequest
	Scenario: TC-01 Send trip Request
	When The User sends a POST request for Request API with the request body from "Send trip Request.json" and captures the response body
	Then The response code for Request API should be "201"
	And The response body for Request API should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 201                           |
  | status  | true                          |
  | message | Request sent successfully...  |
	
	@Requestaccepted
	Scenario: TC-02 Request accepted
	When The User sends a POST request for Request API with the request body from "Request accepted.json" and captures the response body
	Then The response code for Request API should be "200"
	And The response body for Request API should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  | message | Trip Request Accepted.        |
  
  @RequestReject
	Scenario: TC-03 Request Reject
	When The User sends a POST request for Request API with the request body from "Request Reject.json" and captures the response body
	Then The response code for Request API should be "200"
	And The response body for Request API should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  | message | Trip Request Rejected.        |
	
	@Allrequest
	Scenario: TC-04 All request
	When The User sends a POST request for Request API with the request body from "All request.json" and captures the response body
	Then The response code for Request API should be "200"
	And The response body for Request API should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  | message | All Trips.                    |
  
  	@AllConfirmedRequestofUser
	Scenario: TC-05 All Confirmed Request of User
	When The User sends a POST request for Request API with the request body from "All Confirmed Request of User.json" and captures the response body
	Then The response code for Request API should be "200"
	And The response body for Request API should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  | message | All confirmed Trips.          |
	
 