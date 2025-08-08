@UserTest @Shrido
Feature: User Tests  
This feature includes User tests using RESTFul services

	Background:
	Given The User sets the base URL as "https://api-staging.shrido.com.au" for User
	
	@Register
	Scenario: TC-01 Register a New User Successfully
	When The User sends a POST request for User with the request body from "user register.json" and captures the response body
	Then The response code for User should be "201"
	And The response body for User should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 201                           |
  | status  | true                          |
  | message | User Registered Successfully. |
	
	@ReferralHistory
	Scenario: TC-02 Retrieve Referral History
	When The User sends a GET request for User from "Get Referral History" and captures the response body
	Then The response code for User should be "200"
	And The response body for User should contain the following key-value pairs:
	| Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  | message | Referral History.             |
	
	@TotalReferrals
	Scenario: TC-03 Retrieve Total Referrals
	When The User sends a GET request for User from "Get Total Referrals" and captures the response body
	Then The response code for User should be "200"
	And The response body for User should contain the following key-value pairs:
	| Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  | message | Total Referral Points.        |
	
	@OTPVerify
	Scenario: TC-04 Verify OTP
	When The User sends a POST request for User with the request body from "Otp verify.json" and captures the response body
	Then The response code for User should be "200"
	And The response body for User should contain the following key-value pairs:
	| Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  | message | Otp Verified Successfully.    |
	
	@ResendOTP
	Scenario: TC-05 Resend OTP
	When The User sends a POST request for User with the request body from "Resend Otp.json" and captures the response body
	Then The response code for User should be "200"
	And The response body for User should contain the following key-value pairs:
  | Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  | message | Otp sent successfully.        |
	
	@Addrole
	Scenario: TC-06 Assign Role
	When The User sends a POST request for User with the request body from "Add Role.json" and captures the response body
	Then The response code for User should be "200"
	And The response body for User should contain the following key-value pairs:
	| Key     | Value          |
  | code    | 200            |
  | status  | true           |
	| message | User role set. |
  
  @ProfileSetup
	Scenario: TC-07 Setup Profile
	When The User sends a POST request for User with the request body from "Profile_Setup.json" and captures the response body
	Then The response code for User should be "200"
	And The response body for User should contain the following key-value pairs:
	| Key     | Value                         |
  | code    | 200                           |
  | status  | true                          |
  | message | To complete registration, please verify your email address. |
	
	@Referralcode
	Scenario: TC-08 Apply Referral Code
	When The User sends a POST request for User with the request body from "Add Referral Code.json" and captures the response body
	Then The response code for User should be "200"
	And The response body for User should contain the following key-value pairs:
	| Key     | Value                             |
  | code    | 200                               |
  | status  | true                              |
  | message | Referral Code Added Successfully. |
	
	@AddCar
	Scenario: TC-09 Add Car Details
	When The User sends a POST request for User with the request body from "Add car Detail.json" and captures the response body
	Then The response code for User should be "201"
	And The response body for User should contain the following key-value pairs:
	| Key     | Value                           |
  | code    | 201                             |
  | status  | true                            |
  | message | Car details saved successfully. |
  
  @DriverACK
	Scenario: TC-10 Submit Driver Acknowledgement
	When The User sends a POST request for User with the request body from "Driver Acknowledged.json" and captures the response body
	Then The response code for User should be "200"
	And The response body for User should contain the following key-value pairs:
  | Key     | Value                             |
  | code    | 200                               |
  | status  | true                              |
  | message | Driver agreement accepted successfully.|
	
	@License
	Scenario: TC-11 Add License Details
	When The User sends a POST request for User with the request body from "Add License.json" and captures the response body
	Then The response code for User should be "200"
	And The response body for User should contain the following key-value pairs:
  | Key     | Value                             |
  | code    | 200                               |
  | status  | true                              |
  | message |Documents update.                  |
  
  @Threshold
	Scenario: TC-12 Add Threshold values
	When The User sends a POST request for User with the request body from "Threshold Create.json" and captures the response body
	Then The response code for User should be "200"
	And The response body for User should contain the following key-value pairs:
  | Key     | Value                             |
  | code    | 200                               |
  | status  | true                              |
  | message | Earning limit set successfully.   |
  
  @Identity
	Scenario: TC-13 Submit Identity Data
	When The User sends a POST request for User with the request body from "Identity Data.json" and captures the response body
	Then The response code for User should be "200"
	And The response body for User should contain the following key-value pairs:
  | Key     | Value                             |
  | code    | 200                               |
  | status  | true                              |
  | message | Identity data add...              |
  
  @EmailVerify
	Scenario: TC-14 Submit Email Verification
	When The User sends a GET request for User from "Email Verification" and captures the response body
	Then The response code for User should be "200"
	And The response body for User should contain the following key-value pairs:
  | Key     | Value                             |
  | code    | 200                               |
  | status  | true                              |
  | message | Email Verified Succesfully              |
  
  @ResendVerify
	Scenario: TC-15 Submit Resend Verification Link
	When The User sends a POST request for User with the request body from "Resend Verification Link.json" and captures the response body
	Then The response code for User should be "200"
	And The response body for User should contain the following key-value pairs:
  | Key     | Value                                  |
  | code    | 200                                    |
  | status  | true                                   |
  | message | Verification link sent to              |
  
  @UpdateProfile
  Scenario: TC-16 Update Profile
  When The User sends a PUT request for User with the request body from "Update Profile.json" and captures the response body
  Then The response code for User should be "200"
	And The response body for User should contain the following key-value pairs:
  | Key     | Value                                  |
  | code    | 200                                    |
  | status  | true                                   |
  | message | Profile Update...                      |
  
  @IntroCard
	Scenario: TC-17 Get Intro Card of User
	When The User sends a GET request for User from "Get Intro Card of User" and captures the response body
	Then The response code for User should be "200"
	And The response body for User should contain the following key-value pairs:
  | Key     | Value                             |
  | code    | 200                               |
  | status  | true                              |
  | message | Intro Card of user...             |
  
  @AboutMe
	Scenario: TC-18 About Me
	When The User sends a GET request for User from "About Me" and captures the response body
	Then The response code for User should be "200"
	And The response body for User should contain the following key-value pairs:
  | Key     | Value                             |
  | code    | 200                               |
  | status  | true                              |
  | message | All Data of User...               |
  
  @TravelSafety
Scenario: TC-19 Travel Safety
	When The User sends a POST request for User with the request body from "Travel Safety.json" and captures the response body
	Then The response code for User should be "200"
	And The response body for User should contain the following key-value pairs:
  | Key     | Value                                  |
  | code    | 200                                    |
  | status  | true                                   |
  | message | Travel safety settings updated successfully.      |
  
  @DriverPriceValue
Scenario: TC-20 Add Driver Price Value
	When The User sends a POST request for User with the request body from "Add Driver Price Value.json" and captures the response body
	Then The response code for User should be "200"
	And The response body for User should contain the following key-value pairs:
  | Key     | Value                                  |
  | code    | 200                                    |
  | status  | true                                   |
  | message | Custom rates updated successfully      |
  
  @TotalPoints
  Scenario: TC-21 Get User Total Points
	When The User sends a GET request for User from "Get User Total Points" and captures the response body
	Then The response code for User should be "200"
	And The response body for User should contain the following key-value pairs:
  | Key     | Value                             |
  | code    | 200                               |
  | status  | true                              |
  | message | User`s Total Points.              |
  
  @UserDetailsUsingUserId
  Scenario: TC-22 Get User Details Using User Id
	When The User sends a GET request for User from "Get User Details Using User Id" and captures the response body
	Then The response code for User should be "200"
	And The response body for User should contain the following key-value pairs:
  | Key     | Value                             |
  | code    | 200                               |
  | status  | true                              |
  | message | All Data of User...               |
  
  @DeleteUser
  Scenario: TC-23 Delete User
	When The User sends a DELETE request for User from "Delete User" and captures the response body
	Then The response code for User should be "200"
	And The response body for User should contain the following key-value pairs:
  | Key     | Value                             |
  | code    | 200                               |
  | status  | true                              |
  | message | All Data of User...               |
  
  @LogOut
  Scenario: TC-24 LogOut
	When The User sends a POST request for User with the request body from "LogOut.json" and captures the response body
	Then The response code for User should be "200"
	And The response body for User should contain the following key-value pairs:
  | Key     | Value                                  |
  | code    | 200                                    |
  | status  | true                                   |
  | message | Logout Successfully.                   |
  
  
  
  
  