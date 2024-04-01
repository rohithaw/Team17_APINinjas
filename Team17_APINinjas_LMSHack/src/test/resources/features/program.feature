#@ProgramModuleAll
#Feature: Program Module Positive scenarios
#
#Background: Admin able to get Token for Authorization for Program
#		Given Admin logs in with valid Username and password for Program
#		When Admin send Post Login request for Program
#		Then Admin should be able to get 200 in the response and generate Token for Program
    #
 #@POST_Program_DD
  #Scenario: Authorized admin able to create new Program with test data from Excel
    #Given Authorized Admin sets Post Program request with valid Url,valid endpoint, request body from excel
    #When Admin sends POST Program request.
    #Then Admin receives expected status in Post Program response
    #
   #@Get_All_Programs
  #Scenario: Check if admin able to retrieve all programs with valid API Endpoint
    #Given Admin creates GET Request for the program API endpoint to retrieve all program details
    #When Admin sends HTTPS Request to retrieve all program details
    #Then Admin recieves 200 OK and valid response for program
   #
    #@Get_by_ProgramID
  #Scenario: Check if admin able to retrieve program by programID with valid API Endpoint
    #Given Admin creates GET Request for the program API endpoint to retrieve program by programID
    #When Admin sends HTTPS Request to retrieve program with programID
    #Then Admin recieves 200 OK and valid response for program
    #
    #
     #@Get_Program_By_User
  #Scenario: Check if admin able to retrieve program with User details for valid API Endpoint
    #Given Admin creates GET Request for the program API endpoint to retrieve program with User details
    #When Admin sends HTTPS Request to retrieve program with Users details
    #Then Admin recieves 200 OK and valid response for program
    #
    #
     #@PUT_Program_ProgramID
  #Scenario: Authorized admin able to update Program by programID with test data from Excel
    #Given Authorized admin sets Put Program request with valid Url,valid endpoint with program id, request body from excel
    #When Admin sends Put Program request with programID
    #Then Admin receives expected status in Put Program response of particular program ID
    #
     #@PUT_Program_ProgramName
  #Scenario: Authorized admin able to update Program by programName with test data from Excel
    #Given Authorized admin sets Put Program request with valid Url,valid endpoint with program name, request body from excel
    #When Admin sends Put Program request with programName
    #Then Admin receives expected status in Put Program response  of particular program name
    #
      #@Delete_ProgramID
    #Scenario: Authorized admin able to delete Program by programID 
    #Given Authorized admin sets Delete Program by ProgramID request with valid endpoint 
    #When Admin sends Delete Program request with programID
    #Then Admin receives expected status in Delete Program response 
    #
     #@Delete_ProgramName
    #Scenario: Authorized admin able to delete Program by programName 
    #Given Authorized admin sets Delete Program by programName request with valid endpoint 
    #When Admin sends Delete Program request with programName
    #Then Admin receives expected status in Delete Program response 
    #
    