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
   
  @PUT_byUserID
  Scenario: Admin is able to update Admin details with Admin userid and mandatory fields
  Given Admin creates PUT Request with valid data in request body with values only in mandatory fields
  When Admin sends PUT User request
  Then Admin receives expected status in Put User response
 
   @PUT_byLoginStatus
  Scenario: Admin is able to update User Login Status with Admin userid 
  Given Admin creates PUT Request with valid data in request body for LoginStatus 
  When Admin sends PUT User request LoginStatus
  Then  Admin receives expected status in Put User response
  
  @PUT_byRoleProgramBatchStatus
  Scenario: Admin is able to assign User to program/batch by Admin userid 
  Given Admin creates PUT Request with valid data in request body for RoleProgramBatchStatus
  When Admin sends PUT User request for RoleProgramBatchStatus
  Then Admin receives expected status in Put User response
  
  
  