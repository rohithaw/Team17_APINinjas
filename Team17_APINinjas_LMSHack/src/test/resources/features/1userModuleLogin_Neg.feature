Feature: User Login when Admin sets No Auth Negative

	  @InvalidPass_Login
    Scenario: Check if Admin unable to generate token with valid Username and invalid password during Login
    Given User logs in with valid Username and invalid password for Login Module
    When User send Post Login request with valid Username and invalid password for Login Module
    Then User should be able to get 401 in the response and unable to generate Token for invalid password
    
    
    @InvalidUser_Login
    Scenario: Check if Admin unable to generate token with invalid user name and valid password during Login
    Given User logs in with invalid username and valid password for Login Module
    When User send Post Login request invalid user name and valid password password for Login Module
    Then User should be able to get 401 in the response and unable to generate Token with invalid user
    
    
    @InvalidEP_Login
    Scenario Outline: User should not be able to Login with invalid end point
    Given User sets "<Status request>" with valid Url, invalid endpoint and valid request body Login 
    When User sends "<Request Type>" Status to Login for InvalidEP
    Then User receives 404 Not found status in Login response for InvalidEP

    Examples: 
      | Status request   | Request Type |
      | Login            | POST         |
    
    
    @InvalidUrl_Login
    Scenario Outline: User should not be able to Login with invalid Url
    Given User sets "<Status request>" with invalid Url, valid endpoint and valid request body Login
    When User sends "<Request Type>" Status to Login
    Then User receives 404 Not found status in Login response

    Examples: 
      | Status request   | Request Type |
      | Login	          |    POST       |
    

    
    
    
    /////////////////////////////
    
    //////////////Logout
    
    Feature: User Logout Invalid Scenarios

     
    @InvalidUrl_Logout
  Scenario Outline: User should not be able to Logout with invalid Url
    Given User sets "<Status request>" with invalid Url, valid endpoint and valid request body Logout
    When User sends "<Request Type>" Status to Logout
    Then User receives 404 Not found status in Logout response

    Examples: 
      | Status request   | Request Type |
      | Logout	         |    GET      |
   
  @InvalidEP_Logout
  Scenario Outline: User should not be able to Logout with invalid end point
    Given User sets "<Status request>" with valid Url, invalid endpoint and valid request body Logout 
    When User sends "<Request Type>" Status to Logout for InvalidEP
    Then User receives 400 Not found status in Logout response for InvalidEP

    Examples: 
      | Status request   | Request Type |
      | Logout           | GET          |

  @NoAuth_Logout
  Scenario Outline: Unauthorized user not able to Logout 
    Given Unauthorized User sets "<Status request>" with valid baseUrl,valid endpoint for Logout
    When User sends "<Request Type>" status for Logout
    Then User receives 401 Unauthorized Status in Logout response

    Examples: 
      | Status request   | Request Type |
      | Logout           | GET          |
    
    