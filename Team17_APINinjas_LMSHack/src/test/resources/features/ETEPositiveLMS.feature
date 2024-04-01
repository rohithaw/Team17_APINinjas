@ETEPositiveLMS
Feature: LMS API All Modules End To End Positive Scenarios

  Background: Admin able to get Token for Authorization
    Given Admin logs in with valid Username and password
    When Admin send Post Login request
    Then Admin should be able to get 200 in the response and generate Token

  #Program Module
  @POST_Program_DD
  Scenario: Authorized admin able to create new Program with test data from Excel
    Given Authorized Admin sets Post Program request with valid Url,valid endpoint, request body from excel
    When Admin sends POST Program request.
    Then Admin receives expected status in Post Program response

  @Get_All_Programs
  Scenario: Check if admin able to retrieve all programs with valid API Endpoint
    Given Admin creates GET Request for the program API endpoint to retrieve all program details
    When Admin sends HTTPS Request to retrieve all program details
    Then Admin recieves 200 OK and valid response for program

  @Get_by_ProgramID
  Scenario: Check if admin able to retrieve program by programID with valid API Endpoint
    Given Admin creates GET Request for the program API endpoint to retrieve program by programID
    When Admin sends HTTPS Request to retrieve program with programID
    Then Admin recieves 200 OK and valid response for program

  @Get_Program_By_User
  Scenario: Check if admin able to retrieve program with User details for valid API Endpoint
    Given Admin creates GET Request for the program API endpoint to retrieve program with User details
    When Admin sends HTTPS Request to retrieve program with Users details
    Then Admin recieves 200 OK and valid response for program

  @PUT_Program_ProgramID
  Scenario: Authorized admin able to update Program by programID with test data from Excel
    Given Authorized admin sets Put Program request with valid Url,valid endpoint with program id, request body from excel
    When Admin sends Put Program request with programID
    Then Admin receives expected status in Put Program response of particular program ID

  @PUT_Program_ProgramName
  Scenario: Authorized admin able to update Program by programName with test data from Excel
    Given Authorized admin sets Put Program request with valid Url,valid endpoint with program name, request body from excel
    When Admin sends Put Program request with programName
    Then Admin receives expected status in Put Program response  of particular program name

  #Batch Module
  @POST_Batch_DD_Positive
  Scenario: Authorized Admin able to create new Batch
    Given Authorized Admin sets Post Batch request with valid Url,valid endpoint, request body
    When Admin sends POST Batch request.
    Then Admin receives expected status in Post Batch response

  @Get_All_Batches_Positives
  Scenario Outline: : Authorized Admin able to view all Batches
    Given Authorized Admin sets the GET Batches request with or without search "<SearchString>"
    When Admin sends GET Batches request
    Then Admin receives 200 OK Status in Batch response

    Examples: 
      | SearchString |
      | Yes          |
      | No           |

  @Get_by_batchID_Positive
  Scenario: Authorized Admin able to view respective Batch with valid endpoint,valid url,valid batchID
    Given Authorized Admin sets the GET by batchID request with valid baseUrl,valid endpoint ,id
    When Admin sends GET by BatchID request
    Then Admin receives 200 OK Status in Batch response

  @Get_by_programID_Positive
  Scenario: Authorized Admin able to view respective Batch with valid endpoint,valid url,valid programID
    Given Authorized Admin sets the GET by programID request with valid baseUrl,valid endpoint ,id
    When Admin sends GET by programID request
    Then Admin receives 200 OK Status in Batch response

  @Get_by_batchName_Positive
  Scenario: Authorized Admin able to view respective Batch with valid endpoint,valid url,valid batchName
    Given Authorized Admin sets the GET by batchName request with valid baseUrl,valid endpoint ,batchName
    When Admin sends GET by BatchName request
    Then Admin receives 200 OK Status in Batch response

  @PUT_Batch_DD_Positive
  Scenario: Admin should be able to update Batch with valid Url,request body and valid end point
    Given Admin sets Put Batch request with valid Url, invalid endpoint and valid request body
    When Admin sends PUT Batch request
    Then Admin receives expected status in Put Batch response

  #User Module:(Yet to add one put)
  @POST_User_DD
  Scenario: Authorized user able to create new User with Roles from Excel test data
    Given Authorized User sets Post User request with valid Url,valid endpoint, request body from excel
    When User sends POST User request.
    Then User receives expected status in Post User response

  @PUT_byUserID
  Scenario: Admin is able to update Admin details with Admin userid and mandatory fields
    Given Admin creates PUT Request with valid data in request body with values only in mandatory fields
    When Admin sends PUT User request
    Then Admin receives expected status in Put User response

  #Program Batch Status Role Map Module:
  @PutUserProgramBatchStatusUserId_DD
  Scenario Outline: Check if admin is able to assign Admin to with program/batch by Admin Id
    Given Admin creates PUT Request to assign program/batch for a user from excelsheet
    When Admin sends HTTPS Request for PutUserProgramBatchStatusUserId for a user "userID"
    Then User should be able to get 200 in the response for PutUserProgramBatchStatusUserId

  @GetUserProgramBatchAll
  Scenario Outline: Check if admin is able to retreive all users with assigned program batches
    Given Admin creates GET Request to retrieve all users assigned to programs/batches
    When Admin sends HTTPS Request for GetAllUsersPrgmBatch
    Then User should be able to get 200 in the response for GetAllUsersPrgmBatch

  @GetUserProgramBatchUserId
  Scenario Outline: Check if admin is able to retreive assigned program batches for a user
    Given Admin creates GET Request to retrieve assigned to programs/batches for a user
    When Admin sends HTTPS Request for GetUsersPrgmBatchUserId for a user
    Then User should be able to get 200 in the response for GetUsersPrgmBatchUserId for a user

  #User Module Get scenarios:
  @Get_All_Roles
  Scenario: Check if admin able to retrieve all UserRoles with with valid API Endpoint
    Given Admin creates GET Request for the UserRoles API endpoint to retrieve all UserRoles details
    When Admin sends HTTPS Request to retrieve all UserRoles details
    Then Admin recieves 200 OK and valid response for User

  @Get_All_Users
  Scenario: Check if admin able to retrieve all User with valid API Endpoint
    Given Admin creates GET Request for the User API endpoint to retrieve all User details
    When Admin sends HTTPS Request to retrieve all User details
    Then Admin recieves 200 OK and valid response for User

  @Get_Userinfo_By_ID
  Scenario: Check if admin able to retrieve all Userinfo by ID with with valid API Endpoint
    Given Admin creates GET Request for the Userinfo by ID API endpoint to retrieve all User details
    When Admin sends HTTPS Request to retrieve all Userinfo by ID details
    Then Admin recieves 200 OK and valid response for User

  @Get_Active_Users
  Scenario: Check if admin able to retrieve all ActiveUsers with with valid API Endpoint
    Given Admin creates GET Request for the ActiveUsers endpoint to retrieve all User details
    When Admin sends HTTPS Request to retrieve all ActiveUsers details
    Then Admin recieves 200 OK and valid response for User

  @Get_Count_Users
  Scenario Outline: Check if admin able to retrieve count users with with valid API Endpoint
    Given Admin sets the GET Userrequest with UserID "<id>"
    When Admin sends HTTPS Request to retrieve all count users details
    Then Admin recieves 200 OK and valid response for User

    Examples: 
      | id  |
      | all |
      | R01 |
      | R02 |
      | R03 |

  @Get_Users_ProgBatch
  Scenario: Check if admin able to retrieve user by progbatch with with valid API Endpoint
    Given Admin creates GET Request for the user by progbatch endpoint to retrieve all User details
    When Admin sends HTTPS Request to retrieve all user by progbatch details
    Then Admin recieves 200 OK and valid response for User

  @Get_Users_Prog
  Scenario: Check if admin able to retrieve userbyprog with with valid API Endpoint
    Given Admin creates GET Request for the userbyprog endpoint to retrieve all User details
    When Admin sends HTTPS Request to retrieve all userbyprog details
    Then Admin recieves 200 OK and valid response for User

  @Get_UserswithRole
  Scenario: Check if admin able to retrieve UserswithRole with with valid API Endpoint
    Given Admin creates GET Request for the UserswithRole endpoint to retrieve all User details
    When Admin sends HTTPS Request to retrieve all UserswithRole details
    Then Admin recieves 200 OK and valid response for User

  @Get_UserswithRoleID
  Scenario: Check if admin able to retrieve UserswithRoleID with with valid API Endpoint
    Given Admin creates GET Request for the UserswithRoleID endpoint to retrieve all User details
    When Admin sends HTTPS Request to retrieve all UserswithRoleID details
    Then Admin recieves 200 OK and valid response for User

  @Get_UserswithFilters
  Scenario: Check if admin able to retrieve UserswithFilters with with valid API Endpoint
    Given Admin creates GET Request for the UserswithFilters endpoint to retrieve all User details
    When Admin sends HTTPS Request to retrieve all UserswithFilters details
    Then Admin recieves 200 OK and valid response for User

  @PUT_byLoginStatus
  Scenario: Admin is able to update User Login Status with Admin userid
    Given Admin creates PUT Request with valid data in request body for LoginStatus
    When Admin sends PUT User request LoginStatus
    Then Admin receives expected status in Put User response

  @PUT_byRoleProgramBatchStatus
  Scenario: Admin is able to assign User to program/batch by Admin userid
    Given Admin creates PUT Request with valid data in request body for RoleProgramBatchStatus
    When Admin sends PUT User request for RoleProgramBatchStatus
    Then Admin receives expected status in Put User response

  @PUT_User_RoleID_Positive
  Scenario: Admin should be able to update User RoleID with valid Url,request body and valid end point
    Given Admin sets Put User RoleID request with valid Url, invalid endpoint and valid request body
    When Admin sends Put User RoleID request
    Then Admin receives 200 status in Put User RoleID response

  @PUT_User_RoleStatus_Positive
  Scenario: Admin should be able to update User Role status with valid Url,request body and valid end point
    Given Admin sets Put User Role status request with valid Url, invalid endpoint and valid request body
    When Admin sends Put User Role status request
    Then Admin receives 200 status in Put User Role status response

  #Delete requests All Modules
  @DeleteUserProgramBatchUserId
  Scenario Outline: Check if admin is able to delete the program batch for a user
    Given Admin creates Delete Request to delete user assigned to programs/batches for a user
    When Admin sends HTTPS Request for DeleteUsersPrgmBatch for a user
    Then User should be able to get 200 in the response for DeleteUsersPrgmBatch

  @Delete_User
  Scenario: Authorized admin able to delete User
    Given Authorized admin sets Delete User by UserID request with valid endpoint
    When Admin sends Delete User request with UserID
    Then Admin receives 200 OK Status in delete User response

  @Delete_Batch_Positive
  Scenario: Authorized Admin able to delete batch with valid url, end point by valid batch ID
    Given Authorized Admin sets Delete Batch request with valid Url,valid endpoint, batch ID
    When Admin sends Delete Batch request
    Then Admin receives 200 OK Status in Batch response

  @Delete_Program_ProgramID
  Scenario: Authorized admin able to delete Program by programID
    Given Authorized admin sets Delete Program by ProgramID request with valid endpoint
    When Admin sends Delete Program request with programID
    Then Admin receives expected status in Delete Program response

  @Delete_Program_ProgramName
  Scenario: Authorized admin able to delete Program by programName
    Given Authorized admin sets Delete Program by programName request with valid endpoint
    When Admin sends Delete Program request with programName
    Then Admin receives expected status in Delete Program response

  #Logout
  Scenario: Check if Admin able to logout
    Given User logs out using Logout Module
    When Admin calls Get Https method with valid endpoint
    Then Admin should be able to get 200 in the response for Logout Module
