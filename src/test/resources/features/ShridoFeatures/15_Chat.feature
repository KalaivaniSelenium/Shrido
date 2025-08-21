@Chat @Shrido
Feature: Chat  
This feature includes Chat tests using RESTFul services

  Background:
  Given The User sets the base URL as "https://api-staging.shrido.com.au" for Chat

  @GetAllChat
  Scenario: TC-01 Get All Chat (POST {{liveUrl}}/api/chat/all_chat)
  When The User sends a POST request for Chat with the request body from "Get All Chat.json" and captures the response body
  Then The response code for Chat should be "200"
  And The response body for Chat should contain the following key-value pairs:
      | Key     | Value                |
      | code    | 200                  |
      | status  | true                 |
      | message | All chat...          |
