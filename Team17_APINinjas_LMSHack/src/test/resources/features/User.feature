@UserModuleLMS
Feature: LMS API User Modules Scenarios

  Background: Admin able to get Token for Authorization
    Given Admin logs in with valid Username and password for User Module
    When Admin send Post Login request for User Module
    Then Admin should be able to login and generate token for User Module
    
    @POST_User
  Scenario: Authorized user able to create new User with Roles from Excel test data
    Given Authorized User sets Post User request with valid Url,valid endpoint, request body from excel from "PostUserModule"
    When User sends POST User request NN
    Then User receives expected status in Post User response NN
