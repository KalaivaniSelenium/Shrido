@GiftCardsTest  @Shrido
Feature: GiftCards Tests  
This feature includes GiftCards tests using RESTFul services
 
 Background:
  Given The User sets the base URL as "https://api-staging.shrido.com.au" for User
	
  Scenario: TC-01 Get Gift Cards
	When The User sends a GET request for GiftCards API from "Get Gift Cards" and captures the response body
	Then The response code for GiftCards should be "200"
	And The response body for GiftCards should contain the following key-value pairs:
  | Key     | Value                             |
  | code    | 200                               |
  | status  | true                              |
  | message | Cards fetched successfully.       |
	
#	Scenario: TC-02 Redeem gift card
#	When The User sends a POST request for GiftCards with the request body from "Redeem gift card.json" and captures the response body
#	Then The response code for GiftCards should be "200"
#	And The response body for GiftCards should contain the following key-value pairs:
  #| Key     | Value                         |
  #| code    | 200                           |
  #| status  | true                          |
  #| message |                               |
#	
  #Scenario: TC-03 Live Url for get Gift Cards
#	When The User sends a GET request for GiftCards API from "Live Url for get Gift Cards" and captures the response body
#	Then The response code for GiftCards should be "200"
#	And The response body for GiftCards should contain the following key-value pairs:
  #| Key     | Value                             |
  #| code    | 200                               |
  #| status  | true                              |
  #| message |               |
  #

 
 