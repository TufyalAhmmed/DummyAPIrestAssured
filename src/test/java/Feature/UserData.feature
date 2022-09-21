Feature:User Data
  Scenario: Verify List of routes to get User Data
    Given I perform Get Operation For "/post"
    And I perform GET For the list of user by"user"
    Then I should see all the list of user

  Scenario:Verify List of user by who has registration date
    Given I perform Get Operation For query parameter "/post"
    Then I should see  list of user by registration date

  Scenario:Verify Create User
    Given I perform POST Operation for first name last name and email
    Then I should see the created data

  Scenario:Verify Update user
    Given I should perform update user data by ID
    Then I should return Updated Data

  Scenario:Verify Delete User
    Given I should perform Delete Data
    Then i Should return Deleted data with status


