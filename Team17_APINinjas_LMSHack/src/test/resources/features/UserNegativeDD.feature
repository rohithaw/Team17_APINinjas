@LMS, @UserModuleLMS
Feature: LMS API User Modules Scenarios

  Background: Admin able to get Token for Authorization
    Given Admin logs in with valid Username and password for User Module
    When Admin send Post Login request for User Module
    Then Admin should be able to login and generate token for User Module
    
   @POST_User_Negative
  Scenario: Authorized user able to create new User with Roles from Excel test data
    Given Authorized User sets Post User request with valid Url,valid endpoint, request body from excel from "PostUserNegative"
    When User sends POST User request NN
    Then User receives expected responses
    
  @PUT_byLoginStatus_Negative
  Scenario: Admin is able to update User Login Status with Admin userid
    Given Admin creates PUT Request with valid data in request body for LoginStatus from "PutLoginStatusNegative"
    When Admin sends PUT User request LoginStatus for User Module
    Then User receives expected responses

  @PUT_byRoleProgramBatchStatus_Negative
  Scenario: Admin is able to assign User to program/batch by Admin userid
    Given Admin creates PUT Request with valid data in request body for RoleProgramBatchStatus from "PutProgramBatchStatusNegative"
    When Admin sends PUT User request for RoleProgramBatchStatus for User Module
    Then User receives expected responses
    
     @PUT_byUserID_Negative
  Scenario: Admin is able to update Admin details with Admin userid 
    Given Admin creates PUT Request with valid data in request body from "PutUserIdNegative"
    When Admin sends PUT User request for Admin details update in User Module
    Then User receives expected responses
    
    @NoAuth_User
 Scenario Outline: Unauthorized user not able to do CRUD operations on User Module
  Given Unauthorized User sets "<User request>" with valid baseUrl,valid endpoint for User
  When User sends "<Request Type>" User
  Then User receives 401 Unauthorized Status in User response
  Examples:
   | User request     | Request Type |
   | Get_All_roles     | GET     |
   | Get_All_users     | GET     |
   | Get_Userinfo_By_ID  | GET     |
   | Get_Active_Users   | GET     |
   | Get_Count_Users    | GET     |
   | Get_Users_ProgBatch  | GET     |
   | Get_Users_Prog    | GET     |
   | Get_UserswithRole   | GET     |
   | Get_UserswithRoleID  | GET     |
   | Get_UserswithFilters | GET     |
   | Delete_User      | DELETE    |
   @InvalidEP_User
 Scenario Outline: User should not be able to do CRUD operations on User Module with invalid end point
  Given User sets "<User request>" with valid Url, invalid endpoint and valid request body for User
  When User sends "<Request Type>" User
  Then User receives 404 Not found status in User response
  Examples:
   | User request     | Request Type |
   | Get_All_roles     | GET     |
   | Get_All_users     | GET     |
   | Get_Userinfo_By_ID  | GET     |
   | Get_Active_Users   | GET     |
   | Get_Count_Users    | GET     |
   | Get_Users_ProgBatch  | GET     |
   | Get_Users_Prog    | GET     |
   | Get_UserswithRole   | GET     |
   | Get_UserswithRoleID  | GET     |
   | Get_UserswithFilters | GET     |
   | Delete_User      | DELETE    |
   @InvalidUrl_User
 Scenario Outline: User should not be able to do CRUD operations on User Module with invalid Url
  Given User sets "<User request>" with invalid Url, valid endpoint and valid request body for User
  When User sends "<Request Type>" User
  Then User receives 404 Not found status in User response
  Examples:
   | User request  | Request Type |
   | User request     | Request Type |
   | Get_All_roles     | GET     |
   | Get_All_users     | GET     |
   | Get_Userinfo_By_ID  | GET     |
   | Get_Active_Users   | GET     |
   | Get_Count_Users    | GET     |
   | Get_Users_ProgBatch  | GET     |
   | Get_Users_Prog    | GET     |
   | Get_UserswithRole   | GET     |
   | Get_UserswithRoleID  | GET     |
   | Get_UserswithFilters | GET     |
   | Delete_User      | DELETE    |
    