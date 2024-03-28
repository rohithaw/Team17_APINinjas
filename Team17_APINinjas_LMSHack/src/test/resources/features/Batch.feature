@BatchModule
Feature: LMS API Batch Module - Create Batch Requests - Post

  Background: User able to get Token for Authorization
    Given User logs in with valid Username and password for Batch Module
    When User send Post Login request for Batch Module
    Then User should be able to get 200 in the response and generate Token for Batch Module

  @POST_Batch
  Scenario: Authorized user able to create new Batch with test data from Excel
    Given Authorized User sets Post Batch request with valid Url,valid endpoint, request body from excel
    When User sends POST Batch request.
    Then User receives expected status in Post Batch response

  @Get_All_Batches
  Scenario: Authorized user able to view all Batches
    Given Authorized User sets the GET Batches request with valid baseUrl,valid endpoint
    When User sends GET Batches request
    Then User receives 200 OK Status and valid response in GET all Batches response body

  @Get_by_batchID
  Scenario: Authorized user able to view respective Batch with valid endpoint,valid url,valid batchID
    Given Authorized User sets the GET by batchID request with valid baseUrl,valid endpoint ,valid id
    When User sends GET by BatchID request
    Then User receives 200 OK Status and valid response in GET by batchID response body

  #@Get_by_programID
  #Scenario: Authorized user able to view respective Batch with valid endpoint,valid url,valid programID
    #Given Authorized User sets the GET by programID request with valid baseUrl,valid endpoint ,valid id
    #When User sends GET by programID request
    #Then User receives 200 OK Status and valid response in GET by programID response body
#
  #@Get_by_batchName
  #Scenario: Authorized user able to view respective Batch with valid endpoint,valid url,valid batchName
    #Given Authorized User sets the GET by batchName request with valid baseUrl,valid endpoint ,valid batchName
    #When User sends GET by BatchName request
    #Then User receives 200 OK Status and valid response in GET by batchName response body
