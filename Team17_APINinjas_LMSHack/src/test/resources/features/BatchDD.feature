@BatchModule
Feature: LMS API Batch Module - Create Batch Requests - Post

  Background: Admin able to get Token for Authorization
  Given Admin logs in with valid Username and password for Batch Module
  When Admin send Post Login request for Batch Module
  Then Admin should be able to get 200 in the response and generate Token for Batch Module
  
  @POST_Batch_DD_Positive
  Scenario: Authorized Admin able to create new Batch
  Given Authorized Admin sets Post Batch request with valid Url,valid endpoint, request body
  When Admin sends POST Batch request.
  Then Admin receives expected status in Post Batch response
  
  @Get_All_Batches_Positive
  Scenario: Authorized Admin able to view all Batches
  Given Authorized Admin sets the GET Batches request with valid baseUrl,valid endpoint
  When Admin sends GET Batches request
  Then Admin receives 200 OK Status in Batch response
  
  @Get_by_batchID_Positive
  Scenario: Authorized Admin able to view respective Batch with valid endpoint,valid url,valid batchID
  Given Authorized Admin sets the GET by batchID request with valid baseUrl,valid endpoint ,id
  When Admin sends GET by BatchID request
  Then Admin receives 200 OK Status in Batch response
  
  @Get_by_batchID_Negative_DD
  Scenario: Authorized Admin unable to view Batch with invalid batchID from Excel
    When Admin sends GET by BatchID request for Negative scenarios
    Then Admin receives expected Status in Batch response

  @Get_by_programID_Positive
  Scenario: Authorized Admin able to view respective Batch with valid endpoint,valid url,valid programID
  Given Authorized Admin sets the GET by programID request with valid baseUrl,valid endpoint ,id
  When Admin sends GET by programID request
  Then Admin receives 200 OK Status in Batch response
  
  @Get_by_programID_Negative_DD
  Scenario: Authorized Admin unable to view Batch with invalid programID from Excel
    When Admin sends GET by programID request for Negative scenarios
    Then Admin receives expected Status in Batch response

  @Get_by_batchName_Positive
  Scenario: Authorized Admin able to view respective Batch with valid endpoint,valid url,valid batchName
  Given Authorized Admin sets the GET by batchName request with valid baseUrl,valid endpoint ,batchName
  When Admin sends GET by BatchName request
  Then Admin receives 200 OK Status in Batch response
  
  @Get_by_batchName_Negative_DD
  Scenario: Authorized Admin unable to view Batch with invalid batchName from Excel
    When Admin sends GET by BatchName request for Negative scenarios
    Then Admin receives expected Status in get BatchName response

  @PUT_Batch_DD_Positive
  Scenario: Admin should not be able to update Batch with valid Url,request body and invalid end point
  Given Admin sets Put Batch request with valid Url, invalid endpoint and valid request body
  When Admin sends PUT Batch request
  Then Admin receives expected status in Put Batch response
  
  @Delete_Batch_Positive
  Scenario: Authorized Admin able to delete batch with valid url, end point by valid batch ID
  Given Authorized Admin sets Delete Batch request with valid Url,valid endpoint, batch ID
  When Admin sends Delete Batch request
  Then Admin receives 200 OK Status in Batch response
  
  @Delete_Batch_Negative_DD
  Scenario: Authorized Admin unable to delete batch with invalid batch ID from Excel
    When Admin sends Delete Batch request for Negative scenarios
    Then Admin receives expected Status in Batch response
