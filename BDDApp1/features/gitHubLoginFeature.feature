Feature: Google Search Feature
  Using this feature user can able to search very viral information

  #Scenario: User wants to accesss GitHub
    #Given User is on GitHub login Page
    #When user enters Invalid username and password
    #Then 'Incorrect username or password\\.'Message should display
    
  Scenario: User wants to login on their Github Account
   Given User is on login Page
   When User enters their correct credentials
   Then User gets access to their Account
   And User searches the repository