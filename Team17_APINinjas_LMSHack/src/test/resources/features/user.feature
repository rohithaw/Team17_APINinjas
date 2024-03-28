@UserModuleAll
Feature: LMS API User Module 
	Background: User able to get Token for Authorization
		Given User logs in with valid Username and password for User Module
		When User send Post Login request for User Module
		Then User should be able to get 201 in the response and generate Token for User Module
	
  @POST_User_DD
  Scenario: Authorized user able to create new User with Roles from Excel test data
    Given Authorized User sets Post User request with valid Url,valid endpoint, request body from excel
    When User sends POST User request.
    Then User receives expected status in Post User response
    
  