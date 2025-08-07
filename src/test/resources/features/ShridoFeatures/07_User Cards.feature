@UserCardsTest @Shrido
Feature: User Cards Tests  
This feature includes User Cards tests using RESTFul services

  Background:
    Given The User sets the base URL as "https://api-staging.shrido.com.au" for User Cards

  @GetAllUserCards
  Scenario: TC-01 Get All User Cards
  When The User sends a GET request for User Cards with the endpoint "Get all Cards Of User" and captures the response body
  Then The response code for User Cards should be "200"
  And The response body for User Cards should contain the following key-value pairs:
      | Key     | Value                    |
      | code    | 200                      |
      | status  | true                     |
      | message | All Cards .              |

  @AddUserCard
  Scenario: TC-03 Add New User Card
  When The User sends a POST request for User Cards with the request body from "Add Card.json" and captures the response body
  Then The response code for User Cards should be "200"
  And The response body for User Cards should contain the following key-value pairs:
      | Key     | Value                          |
      | code    | 200                            |
      | status  | true                           |
      | message | Card added successfully.       |

  @ChangeCardExpiry
  Scenario: TC-04 Update User Card
  When The User sends a POST request for User Cards with the request body from "Change Card Expiry.json" and captures the response body
  Then The response code for User Cards should be "200"
  And The response body for User Cards should contain the following key-value pairs:
      | Key     | Value                                        |
      | code    | 200                                          |
      | status  | true                                         |
      | message | Card expiry date was updated successfully    |

  @RemoveCard
  Scenario: TC-05 Remove User Card
  When The User sends a POST request for User Cards with the request body from "Remove Card.json" and captures the response body
  Then The response code for User Cards should be "200"
  And The response body for User Cards should contain the following key-value pairs:
      | Key     | Value                            |
      | code    | 200                              |
      | status  | true                             |
      | message | Card removed successfully.       |
      
  @SetCardasDefault
  Scenario: TC-05 Set card as default
  When The User sends a POST request for User Cards with the request body from "Set card as default.json" and captures the response body
  Then The response code for User Cards should be "200"
  And The response body for User Cards should contain the following key-value pairs:
      | Key     | Value                    |
      | code    | 200                      |
      | status  | true                     |
      | message | Default card updated.    |
