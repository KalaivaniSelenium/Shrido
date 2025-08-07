@MSG91Test @Shrido
Feature: MSG91 Tests  
This feature includes MSG91 tests using RESTFul services

	Background:
	Given The User sets the base URL as "https://control.msg91.com" for User
	
	Scenario: TC-01 msg91 send sms
	When The User sends a POST request for MSG91 with the request body from "msg91 send sms.json" and captures the response body
	Then The response code for MSG91 should be "200"
	And The response body for MSG91 should contain the following key-value pairs:
  | Key     | Value                         |
  | type    | success                       |
  
 #Scenario: TC-02 Add Sms Template
#	When The User sends a POST request for MSG91 with the request body from "Add Sms Template.json" and captures the response body
#	Then The response code for MSG91 should be "200"
#	And The response body for MSG91 should contain the following key-value pairs:
  #| Key     | Value                         |
  #| code    | 200                           |
  #| status  | true                          |
  #| message | Contact Sync Successfully.    |
  #
#
