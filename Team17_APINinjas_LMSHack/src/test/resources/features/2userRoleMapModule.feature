@UserProgramBatchModule
Feature: User program batch controller

#@PutUserProgramBatchStatusUserId
  #Scenario Outline: Check if admin is able to assign Admin to with program/batch by Admin Id
    #Given Admin creates PUT Request to assign program/batch for a user, program id "16652", batch id "8608", role id "R03", status "Active"
    #When Admin sends HTTPS Request for PutUserProgramBatchStatusUserId for a user "U404"
    #Then User should be able to get 200 in the response for PutUserProgramBatchStatusUserId
  
#@PutUserProgramBatchStatusUserId_DD
  #Scenario Outline: Check if admin is able to assign Admin to with program/batch by Admin Id
    #Given Admin creates PUT Request to assign program/batch for a user from excelsheet
    #When Admin sends HTTPS Request for PutUserProgramBatchStatusUserId for a user "userid"
    #Then User should be able to get 200 in the response for PutUserProgramBatchStatusUserId
 #
  #
#@GetUserProgramBatchAll
  #Scenario Outline: Check if admin is able to retreive all users with assigned program batches
    #Given Admin creates GET Request to retrieve all users assigned to programs/batches
    #When Admin sends HTTPS Request for GetAllUsersPrgmBatch
    #Then User should be able to get 200 in the response for GetAllUsersPrgmBatch
    #
    #
#@GetUserProgramBatchUserId
  #Scenario Outline: Check if admin is able to retreive assigned program batches for a user 
    #Given Admin creates GET Request to retrieve assigned to programs/batches for a user "userid"
    #When Admin sends HTTPS Request for GetUsersPrgmBatchUserId for a user "userid"
    #Then User should be able to get 200 in the response for GetUsersPrgmBatchUserId for a user
    #
    #
#@DeleteUserProgramBatchUserId
  #Scenario Outline: Check if admin is able to delete the program batch for a user
    #Given Admin creates Delete Request to delete user assigned to programs/batches for a user "userid"
    #When Admin sends HTTPS Request for DeleteUsersPrgmBatch for a user "userid"
    #Then User should be able to get 200 in the response for DeleteUsersPrgmBatch
    #
  