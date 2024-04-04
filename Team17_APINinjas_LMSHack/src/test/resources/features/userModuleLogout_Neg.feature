#Feature: User Logout Invalid Scenarios
#
     #
    #@InvalidUrl_Logout
  #Scenario Outline: User should not be able to Logout with invalid Url
    #Given User sets "<Status request>" with invalid Url, valid endpoint and valid request body Logout
    #When User sends "<Request Type>" Status to Logout
    #Then User receives 404 Not found status in Logout response
#
    #Examples: 
      #| Status request   | Request Type |
      #| Logout	         |    GET      |
   #
  #@InvalidEP_Logout
  #Scenario Outline: User should not be able to Logout with invalid end point
    #Given User sets "<Status request>" with valid Url, invalid endpoint and valid request body Logout 
    #When User sends "<Request Type>" Status to Logout for InvalidEP
    #Then User receives 400 Not found status in Logout response for InvalidEP
#
    #Examples: 
      #| Status request   | Request Type |
      #| Logout           | GET          |
#
  #@NoAuth_Logout
  #Scenario Outline: Unauthorized user not able to Logout 
    #Given Unauthorized User sets "<Status request>" with valid baseUrl,valid endpoint for Logout
    #When User sends "<Request Type>" status for Logout
    #Then User receives 401 Unauthorized Status in Logout response
#
    #Examples: 
      #| Status request   | Request Type |
      #| Logout           | GET          |
    