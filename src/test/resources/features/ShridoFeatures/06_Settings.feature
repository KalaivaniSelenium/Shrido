@SettingsTest @Shrido
Feature: Settings Tests  
This feature includes Settings tests using RESTFul services

	Background:
	Given The User sets the base URL as "https://api-staging.shrido.com.au" for User
	
	@Allsettings
	Scenario: TC-01 All settings
	When The User sends a GET request for Settings from "All settings" and captures the response body
	Then The response code for Settings should be "200"
	And The response body for Settings should contain the following key-value pairs:
	| Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
	| message | All Settings...               |
	
#	@AddPreDefinemessages
#	Scenario: TC-02 Add PreDefine messages
#	When The User sends a POST request for Settings with the request body from "Add PreDefine messages.json" and captures the response body
#	Then The response code for Settings should be "200"
#	And The response body for Settings should contain the following key-value pairs:
  #| Key     | Value                         |
  #| code    | 200                           |
  #| status  | true                          |
  #| message | Contact Sync Successfully.    |
  #
  #@AddApppricevalue
#	Scenario: TC-03 Add App price value
#	When The User sends a POST request for Settings with the request body from "Add App price value.json" and captures the response body
#	Then The response code for Settings should be "200"
#	And The response body for Settings should contain the following key-value pairs:
  #| Key     | Value                         |
  #| code    | 200                           |
  #| status  | true                          |
  #| message | Contact Sync Successfully.    |
  #
  #@AddEmailTemplates
#	Scenario: TC-04 Add Email Templates
#	When The User sends a POST request for Settings with the request body from "Add Email Templates.json" and captures the response body
#	Then The response code for Settings should be "200"
#	And The response body for Settings should contain the following key-value pairs:
  #| Key     | Value                         |
  #| code    | 200                           |
  #| status  | true                          |
  #| message | Contact Sync Successfully.    |
  #
  #@UpdateEmailTemplate
  #Scenario: TC-05 Update Email Template
  #When The User sends a PUT request for Settings with the request body from "Update Email Template.json" and captures the response body
  #Then The response code for Settings should be "200"
#	And The response body for Settings should contain the following key-value pairs:
  #| Key     | Value                                  |
  #| code    | 200                                    |
  #| status  | true                                   |
  #| message | Profile Update...                      |
  #
  #	
#	@AddThresholdValuesLimit
#	Scenario: TC-06 Add Threshold Values Limit
#	When The User sends a POST request for Settings with the request body from "Add Threshold Values Limit.json" and captures the response body
#	Then The response code for Settings should be "200"
#	And The response body for Settings should contain the following key-value pairs:
  #| Key     | Value                         |
  #| code    | 200                           |
  #| status  | true                          |
  #| message | Contact Sync Successfully.    |
  #
  #@EmailTesting
#	Scenario: TC-07 Email Testing
#	When The User sends a POST request for Settings with the request body from "Email Testing.json" and captures the response body
#	Then The response code for Settings should be "200"
#	And The response body for Settings should contain the following key-value pairs:
  #| Key     | Value                         |
  #| code    | 200                           |
  #| status  | true                          |
  #| message | Contact Sync Successfully.    |
  #
  #@AddEmailUs
#	Scenario: TC-08 Add Email Us
#	When The User sends a POST request for Settings with the request body from "Add Email Us.json" and captures the response body
#	Then The response code for Settings should be "200"
#	And The response body for Settings should contain the following key-value pairs:
  #| Key     | Value                         |
  #| code    | 200                           |
  #| status  | true                          |
  #| message | Contact Sync Successfully.    |
#	
