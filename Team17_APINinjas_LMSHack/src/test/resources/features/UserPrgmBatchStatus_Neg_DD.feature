@UserPrgmBatchStatusNegative
Feature: LMS API User Program Batch Status Module

  @PUT_PrgmBatchStatus_Negative_DD_Invalid_Values
  Scenario: Check if admin is unable to assign program/batch by user Id
    Given Admin creates PUT Request to assign program/batch for a user from excelsheet with invalid values
    When Admin sends HTTPS Request for PutUserProgramBatchStatusUserId_Neg for a user "U404"
    Then User should be able to get 400 in the response for PutUserProgramBatchStatusUserId_Neg
    
    
  @InvalidUrl_PrgmBatchStatus
  Scenario Outline: User should not be able to do CRUD operations on PrgmBatchStatus Module with invalid Url
    Given User sets "<Status request>" with invalid Url, valid endpoint and valid request body PrgmBatchStatus
    When User sends "<Request Type>" Status to PrgmBatchStatus
    Then User receives 404 Not found status in PrgmBatchStatus response

    Examples: 
      | Status request   | Request Type |
      | Update           | PUT          |
   
  @InvalidEP_PrgmBatchStatus
  Scenario Outline: User should not be able to do CRUD operations on PrgmBatchStatus Module with invalid end point
    Given User sets "<Status request>" with valid Url, invalid endpoint and valid request body PrgmBatchStatus 
    When User sends "<Request Type>" Status to PrgmBatchStatus for InvalidEP
    Then User receives 404 Not found status in PrgmBatchStatus response for InvalidEP

    Examples: 
      | Status request   | Request Type |
      | Update           | PUT          |

  @NoAuth_PrgmBatchStatus
  Scenario Outline: Unauthorized user not able to do CRUD operations on PrgmBatchStatus Module
    Given Unauthorized User sets "<Status request>" with valid baseUrl,valid endpoint for PrgmBatchStatus
    When User sends "<Request Type>" status for PrgmBatchStatus
    Then User receives 401 Unauthorized Status in PrgmBatchStatus response

    Examples: 
      | Status request   | Request Type |
      | Update           | PUT          |





  @InvalidUrl_PRGM_BATCH_Status_GET_All
  Scenario Outline: User should not be able to do CRUD operations on PrgmBatchStatus Module with invalid Url GetAll
    Given User sets "<Status request>" with invalid Url, valid endpoint and valid request body GetAll
    When User sends "<Request Type>" for PrgmBatchStatus GetAll invalid Url
    Then User receives 404 Not found status in PrgmBatchStatus response GetAll invalid Url

    Examples: 
      | Status request   | Request Type |
      | Get_All          | GET          |

  @InvalidEP_PRGM_BATCH_Status_GET_All
  Scenario Outline: User should not be able to do CRUD operations on PrgmBatchStatus Module with invalid end point GetAll
    Given User sets "<Status request>" with valid Url, invalid endpoint and valid request body GetAll InvalidEP
    When User sends "<Request Type>" for PrgmBatchStatus GetAll InvalidEP
    Then User receives 404 Not found status in PrgmBatchStatus response GetAll InvalidEP

    Examples: 
      | Status request    | Request Type |
      | Get_All           | GET          |

  @NoAuth_PRGM_BATCH_Status_GET_All
  Scenario Outline: Unauthorized user not able to do CRUD operations on PrgmBatchStatus Module GetAll
    Given Unauthorized User sets "<Status request>" with valid baseUrl,valid endpoint GetAll NoAuth
    When User sends "<Request Type>" for PrgmBatchStatus GetAll NoAuth
    Then User receives 401 Unauthorized Status in PrgmBatchStatus response GetAll NoAuth

    Examples: 
      | Status request   | Request Type |
      | Get_All          | GET          |

      
      
      
@InvalidUrl_PRGM_BATCH_Status_USER_ID
  Scenario Outline: User should not be able to do CRUD operations on PrgmBatchStatus Module with invalid Url GET UserID
    Given User sets "<Status request>" with invalid Url, valid endpoint and valid request body GET UserID
    When User sends "<Request Type>" for PrgmBatchStatus GET UserID invalid Url
    Then User receives 404 Not found status in PrgmBatchStatus response GET UserID invalid Url

    Examples: 
      | Status request   | Request Type |
      | Get_UserId       | GET          |

  @InvalidEP_PRGM_BATCH_Status_USER_ID
  Scenario Outline: User should not be able to do CRUD operations on PrgmBatchStatus Module with invalid end point GET UserID
    Given User sets "<Status request>" with valid Url, invalid endpoint and valid request body GET UserID InvalidEP
    When User sends "<Request Type>" for PrgmBatchStatus GET UserID InvalidEP
    Then User receives 404 Not found status in PrgmBatchStatus response GET UserID InvalidEP

    Examples: 
      | Status request    | Request Type |
      | Get_UserId           | GET       |

  @NoAuth_PRGM_BATCH_Status_USER_ID
  Scenario Outline: Unauthorized user not able to do CRUD operations on PrgmBatchStatus Module GET UserID
    Given Unauthorized User sets "<Status request>" with valid baseUrl,valid endpoint GET UserID NoAuth
    When User sends "<Request Type>" for PrgmBatchStatus GET UserID NoAuth
    Then User receives 401 Unauthorized Status in PrgmBatchStatus response GET UserID NoAuth

    Examples: 
      | Status request   | Request Type |
      | Get_UserId          | GET       |

      
      
@InvalidUrl_PRGM_BATCH_Status_Delete
  Scenario Outline: User should not be able to do CRUD operations on PrgmBatchStatus Module with invalid Url Delete
    Given User sets "<Status request>" with invalid Url, valid endpoint and valid request body Delete
    When User sends "<Request Type>" for PrgmBatchStatus Delete invalid Url
    Then User receives 404 Not found status in PrgmBatchStatus response Delete invalid Url

    Examples: 
      | Status request   | Request Type |
      | Delete           | DELETE       |

  @InvalidEP_PRGM_BATCH_Status_USER_ID
  Scenario Outline: User should not be able to do CRUD operations on PrgmBatchStatus Module with invalid end point Delete
    Given User sets "<Status request>" with valid Url, invalid endpoint and valid request body Delete InvalidEP
    When User sends "<Request Type>" for PrgmBatchStatus Delete InvalidEP
    Then User receives 404 Not found status in PrgmBatchStatus response Delete InvalidEP

    Examples: 
      | Status request    | Request Type |
      | Delete            | DELETE       |

  @NoAuth_PRGM_BATCH_Status_USER_ID
  Scenario Outline: Unauthorized user not able to do CRUD operations on PrgmBatchStatus Module Delete
    Given Unauthorized User sets "<Status request>" with valid baseUrl,valid endpoint Delete NoAuth
    When User sends "<Request Type>" for PrgmBatchStatus Delete NoAuth
    Then User receives 401 Unauthorized Status in PrgmBatchStatus response Delete NoAuth

    Examples: 
      | Status request   | Request Type |
      | Delete           | DELETE       |

      
      
      