Feature: User Login when Admin sets No Auth


  Scenario Outline: Check if Admin able to generate token with valid credential during Login
    Given User logs in with valid Username and password for Login Module
    When User send Post Login request for Login Module
    Then User should be able to get 200 in the response and generate Token for Login Module
    
    