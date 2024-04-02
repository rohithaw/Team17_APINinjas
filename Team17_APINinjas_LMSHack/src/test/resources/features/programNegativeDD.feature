@ProgramModule
Feature: LMS API Program Module - Negative scenarios
 Background: Admin able to get Token for Authorization
 Given Admin logs in with valid Username and password for Program Module Negative
 When Admin send Post Login request for Program Module Negative
 Then Admin should be able to get 200 in the response and generate Token for Program Module Negative
  @POST_Program_DD_Negative
 Scenario: Authorized Admin unable to create new Program
  Given Authorized Admin sets Post Program request with valid Url,valid endpoint, invalid request body
  When Admin sends POST Program request for Negative scenarios
  Then Admin receives expected status in Post Program Negative response
  @Get_by_ProgramID_Negative_DD
 Scenario: Authorized Admin unable to view Program with invalid ProgramID from Excel
  When Admin sends GET by ProgramID request for Negative scenarios
  Then Admin receives expected Status in ProgramID response
   @PUT_Program_DD_Negative
 Scenario: Authorized Admin unable to update Program
  Given Admin sets Put Program request with valid Url, invalid endpoint and invalid request body
  When Admin sends PUT Program request for Negative scenarios
  Then Admin receives expected status in Put Program Negative response
 @Delete_ProgramID_Negative_DD
 Scenario: Authorized Admin unable to delete Program with invalid program ID from Excel
  When Admin sends Delete Program request for Negative scenarios
  Then Admin receives expected Status in ProgramID delete response
 @InvalidUrl_Program
 Scenario Outline: User should not be able to do CRUD operations on Program Module with invalid Url
  Given User sets "<Program request>" with invalid Url, valid endpoint and valid request body for Program
  When User sends "<Request Type>" Program
  Then User receives 404 Not found status in Program response
  Examples:
   | Program request  | Request Type |
   | Create       | POST     |
   | Get_All      | GET     |
   | Get_By_ProgramId  | GET     |
   | Get_Program_Users | GET     |
   | Update_By_progID  | PUT     |
   | Update_By_progName | PUT     |
   | Delete_By_ProgID  | DELETE    |
   | Delete_By_ProgName | DELETE    |
 @InvalidEP_Program
 Scenario Outline: User should not be able to do CRUD operations on Program Module with invalid end point
  Given User sets "<Program request>" with valid Url, invalid endpoint and valid request body for Program
  When User sends "<Request Type>" Program
  Then User receives 404 Not found status in Program response
  Examples:
   | Program request  | Request Type |
   | Create       | POST     |
   | Get_All      | GET     |
   | Get_By_ProgramId  | GET     |
   | Get_Program_Users | GET     |
   | Update_By_progID  | PUT     |
   | Update_By_progName | PUT     |
   | Delete_By_ProgID  | DELETE    |
   | Delete_By_ProgName | DELETE    |
 @NoAuth_Program
 Scenario Outline: Unauthorized user not able to do CRUD operations on Program Module
  Given Unauthorized User sets "<Program request>" with valid baseUrl,valid endpoint for Program
  When User sends "<Request Type>" Program
  Then User receives 401 Unauthorized Status in Program response
  Examples:
   | Program request  | Request Type |
   | Create       | POST     |
   | Get_All      | GET     |
   | Get_By_ProgramId  | GET     |
   | Get_Program_Users | GET     |
   | Update_By_progID  | PUT     |
   | Update_By_progName | PUT     |
   | Delete_By_ProgID  | DELETE    |
   | Delete_By_ProgName | DELETE    |