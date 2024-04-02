@UserModuleLMS
Feature: LMS API User Modules Scenarios

  Background: Admin able to get Token for Authorization
    Given Admin logs in with valid Username and password for User Module
    When Admin send Post Login request for User Module
    Then Admin should be able to login and generate token for User Module
    
   #@POST_User_Negative
  #Scenario: Authorized user able to create new User with Roles from Excel test data
    #Given Authorized User sets Post User request with valid Url,valid endpoint, request body from excel from "PostUserNegative"
    #When User sends POST User request NN
    #Then User receives expected responses
    
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