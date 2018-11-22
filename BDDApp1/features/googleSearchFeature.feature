Feature: Google Search Feature
  Using this feature user can able to search very viral information

  Scenario: User want to search information on 'Agile Methodology' by entering valid set of words
    Given User is on Google HomePage
    When User search for 'Agile Methodology'
    Then All links should display with 'Agile Methodology'
    
  #Scenario: User wants to login on their Github Account
   #Given User is on login Page
   #When User enters their correct credentials
   #Then User gets access to their Account
   #And User searches the repository