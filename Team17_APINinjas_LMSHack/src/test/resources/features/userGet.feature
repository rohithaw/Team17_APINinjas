Feature: Program Module Positive scenarios

Background: Admin able to get Token for Authorization for User
		Given Admin logs in with valid Username and password for User
		When Admin send Post Login request for User
		Then Admin should be able to get 200 in the response and generate Token for User
		
		 @Get_All_Roles
  Scenario: Check if admin able to retrieve all UserRoles with  with valid API Endpoint
    Given Admin creates GET Request for the UserRoles API endpoint to retrieve all UserRoles details
    When Admin sends HTTPS Request to retrieve all UserRoles details
    Then Admin recieves 200 OK and valid response for User
		
		 @Get_All_Users
  Scenario: Check if admin able to retrieve all User with valid API Endpoint
    Given Admin creates GET Request for the User API endpoint to retrieve all User details
    When Admin sends HTTPS Request to retrieve all User details
    Then Admin recieves 200 OK and valid response for User
    
    @Get_Userinfo_By_ID
    Scenario: Check if admin able to retrieve all Userinfo by ID with  with valid API Endpoint
    Given Admin creates GET Request for the Userinfo by ID API endpoint to retrieve all User details
    When Admin sends HTTPS Request to retrieve all Userinfo by ID details
    Then Admin recieves 200 OK and valid response for User
    
     @Get_Active_Users
      Scenario: Check if admin able to retrieve all ActiveUsers with  with valid API Endpoint
    Given Admin creates GET Request for the ActiveUsers endpoint to retrieve all User details
    When Admin sends HTTPS Request to retrieve all ActiveUsers details
    Then Admin recieves 200 OK and valid response for User
    
      @Get_Count_Users
       Scenario Outline: Check if admin able to retrieve count users with  with valid API Endpoint
    Given Admin sets the GET Userrequest with UserID "<id>"
    When Admin sends HTTPS Request to retrieve all count users details
    Then Admin recieves 200 OK and valid response for User
     Examples: 
      | id   |
      | all  |
      | R01  |
      | R02  | 
      | R03  |
    
     @Get_Users_ProgBatch
       Scenario: Check if admin able to retrieve user by progbatch with  with valid API Endpoint
    Given Admin creates GET Request for the user by progbatch endpoint to retrieve all User details
    When Admin sends HTTPS Request to retrieve all user by progbatch details
    Then Admin recieves 200 OK and valid response for User
    
    @Get_Users_Prog
       Scenario: Check if admin able to retrieve userbyprog with  with valid API Endpoint
    Given Admin creates GET Request for the userbyprog endpoint to retrieve all User details
    When Admin sends HTTPS Request to retrieve all userbyprog details
    Then Admin recieves 200 OK and valid response for User
    
     @Get_UserswithRole
       Scenario: Check if admin able to retrieve UserswithRole with  with valid API Endpoint
    Given Admin creates GET Request for the UserswithRole endpoint to retrieve all User details
    When Admin sends HTTPS Request to retrieve all UserswithRole details
    Then Admin recieves 200 OK and valid response for User
    
     @Get_UserswithRoleID
       Scenario: Check if admin able to retrieve UserswithRoleID with  with valid API Endpoint
    Given Admin creates GET Request for the UserswithRoleID endpoint to retrieve all User details
    When Admin sends HTTPS Request to retrieve all UserswithRoleID details
    Then Admin recieves 200 OK and valid response for User
    
     @Get_UserswithFilters
       Scenario: Check if admin able to retrieve UserswithFilters with  with valid API Endpoint
    Given Admin creates GET Request for the UserswithFilters endpoint to retrieve all User details
    When Admin sends HTTPS Request to retrieve all UserswithFilters details
    Then Admin recieves 200 OK and valid response for User
	
	  @Delete_User
    Scenario: Authorized admin able to delete User 
    Given Authorized admin sets Delete User by UserID request with valid endpoint 
    When Admin sends Delete User request with UserID
    Then Admin receives 200 OK Status in delete User response 
#		
#		
    