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
    #
  #@PUT_byLoginStatus_Negative
  #Scenario: Admin is able to update User Login Status with Admin userid
    #Given Admin creates PUT Request with valid data in request body for LoginStatus from "PutLoginStatusNegative"
    #When Admin sends PUT User request LoginStatus for User Module
    #Then User receives expected responses
#
  #@PUT_byRoleProgramBatchStatus_Negative
  #Scenario: Admin is able to assign User to program/batch by Admin userid
    #Given Admin creates PUT Request with valid data in request body for RoleProgramBatchStatus from "PutProgramBatchStatusNegative"
    #When Admin sends PUT User request for RoleProgramBatchStatus for User Module
    #Then User receives expected responses
    #
     @PUT_byUserID_Negative
  Scenario: Admin is able to update Admin details with Admin userid 
    Given Admin creates PUT Request with valid data in request body from "PutUserIdNegative"
    When Admin sends PUT User request for Admin details update in User Module
    Then User receives expected responses
    
      @PUT_User_RoleID_Negative
  Scenario: Admin should be able to update User RoleID with valid Url,request body and valid end point
    Given Admin sets Put User RoleID request with valid Url, invalid endpoint and valid request body from "PutUserRoleIdNegative"
    When Admin sends Put User RoleID request in User Module
    Then User receives expected responses
    
    