@WalletTest @Shrido
Feature: Wallet Tests  
This feature includes Wallet tests using RESTFul services

  Background:
  Given The User sets the base URL as "https://api-staging.shrido.com.au" for Wallet

  @GetWalletHistory
  Scenario: TC-01 Get Wallet History
  When The User sends a POST request for Wallet with the request body from "Get Wallet History.json" and captures the response body
  Then The response code for Wallet should be "200"
  And The response body for Wallet should contain the following key-value pairs:
      | Key     | Value                       |
      | code    | 200                         |
      | status  | true                        |
      | message | Wallet history              |
