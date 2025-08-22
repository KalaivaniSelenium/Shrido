@UserSettingsTest @Shrido
Feature: User Settings Tests  
This feature includes User Settings tests using RESTFul services

  Background:
  Given The User sets the base URL as "https://api-staging.shrido.com.au" for User Settings

  @UpdateAutoRefill
  Scenario: TC-01 Update Auto Refill and Renew Settings
  When The User sends a POST request for User Settings with the request body from "Update Auto Refill and Renew Settings.json" and captures the response body
  Then The response code for User Settings should be "202"
  And The response body for User Settings should contain the following key-value pairs:
      | Key     | Value                                   |
      | code    | 200                                     |
      | status  | true                                    |
      | message | Your wallet will automatically be credited with $10 worth of points when your balance falls below $10 |

  @DriverSettings
  Scenario: TC-02 Update Driver Settings
  When The User sends a POST request for User Settings with the request body from "Driver Settings.json" and captures the response body
  Then The response code for User Settings should be "200"
  And The response body for User Settings should contain the following key-value pairs:
      | Key     | Value                                |
      | code    | 200                                  | 
      | status  | true                                 |
      | message | Driver settings updated successfully |

  @PassengerSettings
  Scenario: TC-03 Update Passenger Settings
  When The User sends a POST request for User Settings with the request body from "Passenger Settings.json" and captures the response body
  Then The response code for User Settings should be "200"
  And The response body for User Settings should contain the following key-value pairs:
      | Key     | Value                                    |
      | code    | 200                                      | 
      | status  | true                                     |
      | message | Passenger settings updated successfully. |


  @NotificationSettings
  Scenario: TC-04 Update Notification Settings
  When The User sends a POST request for User Settings with the request body from "Notification Settings.json" and captures the response body
  Then The response code for User Settings should be "200"
  And The response body for User Settings should contain the following key-value pairs:
      | Key     | Value                                       |
      | code    | 200                                         |
      | status  | true                                        |
      | message | Notification settings updated successfully. |
