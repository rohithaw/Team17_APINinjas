#@BatchModule
#Feature: LMS API Batch Module - Create Batch Requests - Post
#
  #Background: Admin able to get Token for Authorization
    #Given Admin logs in with valid Username and password for Batch Module
    #When Admin send Post Login request for Batch Module
    #Then Admin should be able to get 200 in the response and generate Token for Batch Module
#
  #@POST_Batch
  #Scenario: Authorized Admin able to create new Batch
    #Given Authorized Admin sets Post Batch request with valid Url,valid endpoint, request body
    #When Admin sends POST Batch request.
    #Then Admin receives expected status in Post Batch response
#
  #@Get_All_Batches
  #Scenario: Authorized Admin able to view all Batches
    #Given Authorized Admin sets the GET Batches request with valid baseUrl,valid endpoint
    #When Admin sends GET Batches request
    #Then Admin receives 200 OK Status in Batch response
#
  #@Get_by_batchID
  #Scenario: Authorized Admin able to view respective Batch with valid endpoint,valid url,valid batchID
    #Given Authorized Admin sets the GET by batchID request with valid baseUrl,valid endpoint ,valid id
    #When Admin sends GET by BatchID request
    #Then Admin receives 200 OK Status in Batch response
#
  #@Get_by_programID
  #Scenario: Authorized Admin able to view respective Batch with valid endpoint,valid url,valid programID
    #Given Authorized Admin sets the GET by programID request with valid baseUrl,valid endpoint ,valid id
    #When Admin sends GET by programID request
    #Then Admin receives 200 OK Status in Batch response
#
  #@Get_by_batchName
  #Scenario: Authorized Admin able to view respective Batch with valid endpoint,valid url,valid batchName
    #Given Authorized Admin sets the GET by batchName request with valid baseUrl,valid endpoint ,valid batchName
    #When Admin sends GET by BatchName request
    #Then Admin receives 200 OK Status in Batch response
#
  #@PUT_Batch
  #Scenario: Admin should not be able to update Batch with valid Url,request body and invalid end point
    #Given Admin sets Put Batch request with valid Url, invalid endpoint and valid request body
    #When Admin sends PUT Batch request
    #Then Admin receives 200 OK status in Put Batch response
#
  #@Delete_Batch
  #Scenario: Authorized Admin able to delete batch with valid url, end point by valid batch ID
    #Given Authorized Admin sets Delete Batch request with valid Url,valid endpoint by valid batch ID
    #When Admin sends Delete Batch request
    #Then Admin receives 200 OK Status in Batch response
