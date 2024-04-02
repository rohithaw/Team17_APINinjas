Feature: LMS API Program Module - Negative scenarios

  Background: Admin able to get Token for Authorization
  Given Admin logs in with valid Username and password for User Module Negative
  When Admin send Post Login request for User Module Negative
  Then Admin should be able to get 200 in the response and generate Token for User Module Negative
  
   @NoAuth_User
  Scenario Outline: Unauthorized user not able to do CRUD operations on User Module
    Given Unauthorized User sets "<User request>" with valid baseUrl,valid endpoint for User
    When User sends "<Request Type>" User
    Then User receives 401 Unauthorized Status in User response

    Examples: 
      | User request          | Request Type |
      | Get_All_roles         | GET          |
      | Get_All_users         | GET          |
      | Get_Userinfo_By_ID    | GET          |
      | Get_Active_Users      | GET          |
      | Get_Count_Users       | GET          |
      | Get_Users_ProgBatch   | GET          |
      | Get_Users_Prog        | GET          |
      | Get_UserswithRole     | GET          |
      | Get_UserswithRoleID   | GET          |
      | Get_UserswithFilters  | GET          |
      | Delete_User           | DELETE       |
      
      
      @InvalidEP_User
  Scenario Outline: User should not be able to do CRUD operations on User Module with invalid end point
    Given User sets "<User request>" with valid Url, invalid endpoint and valid request body for User
    When User sends "<Request Type>" User
    Then User receives 404 Not found status in User response

    Examples: 
      | User request          | Request Type |
      | Get_All_roles         | GET          |
      | Get_All_users         | GET          |
      | Get_Userinfo_By_ID    | GET          |
      | Get_Active_Users      | GET          |
      | Get_Count_Users       | GET          |
      | Get_Users_ProgBatch   | GET          |
      | Get_Users_Prog        | GET          |
      | Get_UserswithRole     | GET          |
      | Get_UserswithRoleID   | GET          |
      | Get_UserswithFilters  | GET          |
      | Delete_User           | DELETE       |
      
      
      @InvalidUrl_User
  Scenario Outline: User should not be able to do CRUD operations on User Module with invalid Url
    Given User sets "<User request>" with invalid Url, valid endpoint and valid request body for User
    When User sends "<Request Type>" User
    Then User receives 404 Not found status in User response

    Examples: 
      | User request    | Request Type |
      | User request          | Request Type |
      | Get_All_roles         | GET          |
      | Get_All_users         | GET          |
      | Get_Userinfo_By_ID    | GET          |
      | Get_Active_Users      | GET          |
      | Get_Count_Users       | GET          |
      | Get_Users_ProgBatch   | GET          |
      | Get_Users_Prog        | GET          |
      | Get_UserswithRole     | GET          |
      | Get_UserswithRoleID   | GET          |
      | Get_UserswithFilters  | GET          |
      | Delete_User           | DELETE       |
