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
   
    #Positive-2scenarios
  @PUT_Admin_Info
  Scenario: Admin is able to update Admin details with Admin userid and mandatory fields
  Given Admin creates PUT Request with valid data in request body with values only in mandatory fields
  When Admin sends PUT User request
  Then Admin receives 200 OK status in Put User response
  # Scenario: Admin is able to update Admin details with Admin userid  and valid data in all fields
  
  #Negative-3scenarios
  #Scenario: Admin is able to update Admin details with  Admin userid and invalid data
  #Given Admin creates PUT Request with invalid data in request body 
  #When Admin sends PUT User request
  #Then Admin receives 400 Bad Request Status with message and boolean success details
  # Scenario: Admin is able to update Admin details with invalid AdminId
  # Scenario: Admin is able to update Admin details with No authorization
  