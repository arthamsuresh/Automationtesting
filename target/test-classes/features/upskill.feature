@tag
Feature: Upskill application

  @tag1
  Scenario Outline: Entering the signup details in Upskill application
    Given Launch the browser
    And click on signup link
    When enter signup details "<First Name>","<Last Name>","<e-mail>","<UserName>","<Pass>","<Confirm password>" and click on Register button
        

Then User validates Registration details

   			|FirstName|suresh|

    		|LastName | kumar|

    		|EMail    |test@gmail.com|

    And User sends an email "<toMailId>" "<subject>" "<message>" 

    And User validates success message "<toMailId>"

    Then User logouts from the application

    Examples: 
      | First Name | Last Name | e-mail         | UserName | Pass    | Confirm password |                                                                        |
      | suresh     | kumar     | test@gmail.com | test7123  | test7123 | test7123       | 
  

    
    

    Examples:

    |toMailId           |subject     |message     |

    |test@gmail.com|Tester 1234|Test 1234|