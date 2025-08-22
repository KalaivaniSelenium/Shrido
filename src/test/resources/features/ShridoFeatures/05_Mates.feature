@MatesTest @Shrido
Feature: Mates Tests  
This feature includes Mates tests using RESTFul services

	Background:
	Given The User sets the base URL as "https://api-staging.shrido.com.au" for Mates
	
	@GetLatestFriends
	Scenario: TC-01 Get Latest Friends
	When The User sends a GET request for Mates from "Get Latest Friends" and captures the response body
	Then The response code for Mates should be "200"
	And The response body for Mates should contain the following key-value pairs:
	| Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
	
	@GetAllMates
	Scenario: TC-02 Get All Mates
	When The User sends a GET request for Mates from "Get All Mates" and captures the response body
	Then The response code for Mates should be "200"
	And The response body for Mates should contain the following key-value pairs:
	| Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  | message | All Mate.                     |
  
	@SyncContact
	Scenario: TC-03 Sync Contact
	When The User sends a POST request for Mates with the request body from "Sync Contact.json" and captures the response body
	Then The response code for Mates should be "200"
	And The response body for Mates should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  | message | Contact Sync Successfully.    |
	
	@Sendfriendrequest
	Scenario: TC-04 Send friend request
	When The User sends a POST request for Mates with the request body from "Send friend request.json" and captures the response body
	Then The response code for Mates should be "200"
	And The response body for Mates should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  | message | Friend Request Sent...        |
  
  @Updatefriendrequeststatus
	Scenario: TC-05 Update friend request status
	When The User sends a POST request for Mates with the request body from "Update friend request status.json" and captures the response body
	Then The response code for Mates should be "200"
	And The response body for Mates should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  | message | Friend Request Accepted...    |
	
	@FavouriteorUnfavouritefriend
	Scenario: TC-06 Favourite or Unfavourite friend
	When The User sends a POST request for Mates with the request body from "Favourite or Unfavourite friend.json" and captures the response body
	Then The response code for Mates should be "200"
	And The response body for Mates should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  | message | Update Favourite Status.      |
  
  @GetUser'sFavouritesfriends
	Scenario: TC-07 Get User's Favourites friends
	When The User sends a GET request for Mates from "Get User's Favourites friends" and captures the response body
	Then The response code for Mates should be "200"
	And The response body for Mates should contain the following key-value pairs:
	| Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  | message | All Favourites Friends...     |
	
	@GetMatesfromride
	Scenario: TC-08 GetMatesfromride
	When The User sends a GET request for Mates from "Get Mates from ride" and captures the response body
	Then The response code for Mates should be "200"
	And The response body for Mates should contain the following key-value pairs:
	| Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  | message | Mates from rides...           |
  
  @Getfriendsfromcontact
	Scenario: TC-09 Get friends from contact
	When The User sends a GET request for Mates from "Get friends from contact" and captures the response body
	Then The response code for Mates should be "200"
	And The response body for Mates should contain the following key-value pairs:
	| Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  | message | All mates from contacts.      |
  
  @Notifyfavouritefriendsabouttrip
	Scenario: TC-10 Notify favourite friends about trip
	When The User sends a POST request for Mates with the request body from "Notify favourite friends about trip.json" and captures the response body
	Then The response code for Mates should be "200"
	And The response body for Mates should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  | message | Sent Trip Details to all selected mates. |
  
  @UserBlock
	Scenario: TC-11 User Block
	When The User sends a POST request for Mates with the request body from "User Block.json" and captures the response body
	Then The response code for Mates should be "200"
	And The response body for Mates should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  | message | User Blocked.                 |
	
  @GetallUserswhouseApplication
	Scenario: TC-12 Get all Users who use Application
	When The User sends a GET request for Mates from "Get all Users who use Application" and captures the response body
	Then The response code for Mates should be "200"
	And The response body for Mates should contain the following key-value pairs:
	| Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  | message | All Users..                   |
