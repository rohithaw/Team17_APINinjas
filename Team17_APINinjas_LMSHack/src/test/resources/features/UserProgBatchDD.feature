 Feature: Program Module Positive scenarios

Background: Admin able to get Token for Authorization for User
		Given Admin logs in with valid Username and password for UserProgBatch
		When Admin send Post Login request for User for UserProgBatch
		Then Admin should be able to get 200 in the response and generate Token for UserProgBatch
		
 #Program Batch Status Role Map Module:
  @PutUserProgramBatchStatusUserId_DD
  Scenario Outline: Check if admin is able to assign User to  program/batch by User Id
    Given Admin creates PUT Request to assign programbatch for a user from excelsheet
    When Admin sends HTTPS Request for PutUserProgramBatchStatusUserId for a user
    Then User should be able to get 200 in the response for PutUserProgramBatchStatusUserId
#
  #@GetUserProgramBatchAll
  #Scenario Outline: Check if admin is able to retreive all users with assigned program batches
    #Given Admin creates GET Request to retrieve all users assigned to programs/batches
    #When Admin sends HTTPS Request for GetAllUsersPrgmBatch
    #Then User should be able to get 200 in the response for GetAllUsersPrgmBatch
#
  #@GetUserProgramBatchUserId
  #Scenario Outline: Check if admin is able to retreive assigned program batches for a user
    #Given Admin creates GET Request to retrieve assigned to programs/batches for a user "userID"
    #When Admin sends HTTPS Request for GetUsersPrgmBatchUserId for a user "userID"
    #Then User should be able to get 200 in the response for GetUsersPrgmBatchUserId for a user
    #
    #@DeleteUserProgramBatchUserId
  #Scenario Outline: Check if admin is able to delete the program batch for a user
    #Given Admin creates Delete Request to delete user assigned to programs/batches for a user "U404"
    #When Admin sends HTTPS Request for DeleteUsersPrgmBatch for a user "U404"
    #Then User should be able to get 200 in the response for DeleteUsersPrgmBatch
    