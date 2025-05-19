Feature: Login

 Scenario: Verify valid login
  When user enters valid username and password
	Then user should see home page

 Scenario: Verify valid login error message
 	When user enter valid user name and password is not provided
 	Then user should see appropriate error message
 	

 Scenario: Validate the user name displayed in user name field
 	When user enter valid username and password along with remember me checkbox clicked
 	Then user should see valid user name populated after logout
 
 
 Scenario: Validate password reset email is sent when user forget password
 	When user enter valid username and click forgot password link
 	Then user should recieve password reset email to associated email
 	
 	
 Scenario: Validate LoginError Message
 	When user enter invalid username and password
 	Then user should see valid error message
 	
 	
 	Scenario: Select user menu for <username> drop down
		When After valid login, check for the user menu drop down
		Then Drop down should contain expected list of menus
		

  Scenario: Navigate to My Profile
    When After valid login, check for the user menu drop down
    Then The User Profile page should be displayed
    
    When User clicks the edit button next to contact information
    Then Edit profile pop-up window should be displayed and update lastname in the profile page
    And User enter text in post and share in profile page
    And User upload a file and share in profile page
    And User upload a profile photo in profile page
   
 