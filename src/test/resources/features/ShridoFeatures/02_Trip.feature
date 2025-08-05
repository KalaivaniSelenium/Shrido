@TripTest  @Shrido
Feature: Trip Tests  
This feature includes Trip tests using RESTFul services

	Background:
	Given The User sets the base URL as "https://api-staging.shrido.com.au" for User
	
	@CreateTrip
	Scenario: TC-01 Create Trip
	When The User sends a POST request for Trip with the request body from "Create Trip.json" and captures the response body
	Then The response code for Trip should be "200"
	And The response body for Trip should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  | message | Your planned trip has been scheduled. Tap on 'Rides' to view your trip request. |
	
	@Searchalltrip
	Scenario: TC-02 Search all trip
	When The User sends a POST request for Trip with the request body from "Search all trip.json" and captures the response body
	Then The response code for Trip should be "200"
	And The response body for Trip should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  | message | All Trips...                  |
	
  @getnexttrip
  Scenario: TC-03 Get next trip
	When The User sends a GET request for Trip from "Get next trip.json" and captures the response body
	Then The response code for Trip should be "200"
	And The response body for Trip should contain the following key-value pairs:
  | Key     | Value                             |
  | code    | 200                               |
  | status  | true                              |
  | message | Next trip..                       |
  
  @updatetripstatus
	Scenario: TC-04 Update trip status
	When The User sends a POST request for Trip with the request body from "Update trip status.json" and captures the response body
	Then The response code for Trip should be "200"
	And The response body for Trip should contain the following key-value pairs:
  | Key     | Value                           |
  | code    | 200                             |
  | status  | true                            |
  | message | Trip Status updated completed.. |
	
	@EndUserTrip
	Scenario: TC-05 End User Trip
	When The User sends a POST request for Trip with the request body from "End User Trip.json" and captures the response body
	Then The response code for Trip should be "200"
	And The response body for Trip should contain the following key-value pairs:
  | Key     | Value                            |
  | code    | 200                              |
  | status  | true                             |
  | message | Driver trip is End Successfully. |
  
  @HistoryofTrips
	Scenario: TC-06 History of Trips
	When The User sends a POST request for Trip with the request body from "History of Trips.json" and captures the response body
	Then The response code for Trip should be "200"
	And The response body for Trip should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  | message | History of Trips...           |
  
  @Deletetrip
  Scenario: TC-07 Delete trip
	When The User sends a DELETE request for Trip from "Delete trip" and captures the response body
	Then The response code for Trip should be "200"
	And The response body for Trip should contain the following key-value pairs:
  | Key     | Value                             |
  | code    | 200                               |
  | status  | true                              |
  | message | Trip Deleted...                   |
  
  @GetAllDatesofTrips
  Scenario: TC-08 Get All Dates of Trips
	When The User sends a GET request for Trip API from "Get All Dates of Trips" and captures the response body
	Then The response code for Trip should be "200"
	And The response body for Trip should contain the following key-value pairs:
  | Key     | Value                                           |
  | code    | 200                                             |
  | status  | true                                            |
  | message | All dates of user's trips which is scheduled.   |
  
  @Re-Scheduletriptime
  Scenario: TC-09 Re-Schedule trip time
  When The User sends a PATCH request for Trip with the request body from "Re-Schedule trip time.json" and captures the response body
  Then The response code for Trip should be "200"
	And The response body for Trip should contain the following key-value pairs:
  | Key     | Value                                  |
  | code    | 200                                    |
  | status  | true                                   |
  | message | Trip time is re-scheduled.             |

  
  
  