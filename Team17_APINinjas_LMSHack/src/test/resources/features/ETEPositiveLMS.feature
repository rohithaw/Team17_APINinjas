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
  Scenario: Admin should not be able to update Batch with valid Url,request body and invalid end point
    Given Admin sets Put Batch request with valid Url, invalid endpoint and valid request body
    When Admin sends PUT Batch request
    Then Admin receives expected status in Put Batch response

#User Module-Yet to be added

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
