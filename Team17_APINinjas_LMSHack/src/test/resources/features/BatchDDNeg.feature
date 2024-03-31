@BatchModuleNegative
Feature: LMS API Batch Module - Create Batch Requests - Post

  Background: Admin able to get Token for Authorization
  Given Admin logs in with valid Username and password for Batch Module Negative
  When Admin send Post Login request for Batch Module Negative
  Then Admin should be able to get 200 in the response and generate Token for Batch Module Negative
  
  @POST_Batch_DD_Negative
  Scenario: Authorized Admin unable to create new Batch
    Given Authorized Admin sets Post Batch request with valid Url,valid endpoint, invalid request body
    When Admin sends POST Batch request for Negative scenarios
    Then Admin receives expected status in Post batch Negative response

  @Get_by_batchID_Negative_DD
  Scenario: Authorized Admin unable to view Batch with invalid batchID from Excel
    When Admin sends GET by BatchID request for Negative scenarios
    Then Admin receives expected Status in BatchID response

  @Get_by_programID_Negative_DD
  Scenario: Authorized Admin unable to view Batch with invalid programID from Excel
    When Admin sends GET by programID request for Negative scenarios
    Then Admin receives expected Status in get programID response

  @Get_by_batchName_Negative_DD
  Scenario: Authorized Admin unable to view Batch with invalid batchName from Excel
    When Admin sends GET by BatchName request for Negative scenarios
    Then Admin receives expected Status in get BatchName response

  @PUT_Batch_DD_Negative
  Scenario: Authorized Admin unable to update Batch
    Given Admin sets Put Batch request with valid Url, invalid endpoint and invalid request body
    When Admin sends PUT Batch request for Negative scenarios
    Then Admin receives expected status in Put batch Negative response

  @Delete_Batch_Negative_DD
  Scenario: Authorized Admin unable to delete batch with invalid batch ID from Excel
    When Admin sends Delete Batch request for Negative scenarios
    Then Admin receives expected Status in BatchID response

  @InvalidUrl_Batch
  Scenario Outline: User should not be able to do CRUD operations on Batch Module with invalid Url
    Given User sets "<Batch request>" with invalid Url, valid endpoint and valid request body
    When User sends "<Request Type>" Batch
    Then User receives 404 Not found status in Batch response

    Examples: 
      | Batch request    | Request Type |
      | Create           | POST         |
      | Get_All          | GET          |
      | Get_By_BatchId   | GET          |
      | Get_By_ProgramId | GET          |
      | Get_By_BatchName | GET          |
      | Update           | PUT          |
      | Delete           | DELETE       |

  @InvalidEP_Batch
  Scenario Outline: User should not be able to do CRUD operations on Batch Module with invalid end point
    Given User sets "<Batch request>" with valid Url, invalid endpoint and valid request body.
    When User sends "<Request Type>" Batch
    Then User receives 404 Not found status in Batch response

    Examples: 
      | Batch request    | Request Type |
      | Create           | POST         |
      | Get_All          | GET          |
      | Get_By_BatchId   | GET          |
      | Get_By_ProgramId | GET          |
      | Get_By_BatchName | GET          |
      | Update           | PUT          |
      | Delete           | DELETE       |

  @NoAuth_Batch
  Scenario Outline: Unauthorized user not able to do CRUD operations on Batch Module
    Given Unauthorized User sets "<Batch request>" with valid baseUrl,valid endpoint
    When User sends "<Request Type>" Batch
    Then User receives 401 Unauthorized Status in Batch response

    Examples: 
      | Batch request    | Request Type |
      | Create           | POST         |
      | Get_All          | GET          |
      | Get_By_BatchId   | GET          |
      | Get_By_ProgramId | GET          |
      | Get_By_BatchName | GET          |
      | Update           | PUT          |
      | Delete           | DELETE       |
