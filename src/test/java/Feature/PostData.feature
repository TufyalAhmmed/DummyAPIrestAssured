Feature:Post Data

  Scenario: Verify Get Post List
    Given I perform GET operation for "Post" by Creation date
    Then I should see the Get list

  Scenario: Verify Get List by User
    Given Get list of posts for specific user sorted by creation date.
    Then I should see the get list by user

  Scenario: Verify Get list by Tag
    Given I perform GET operation for the list created by "Tag"
    Then I should see the get liSt by Tag

  Scenario: Verify GET list post by ID
    Given I perform GET operation for the full data of a post id
    Then I should see the data by post id

  Scenario: Verify POST
    Given I perform POST Operation for owner and post data
    Then I should see the created post data

  Scenario: Verify Update
    Given I should perform update post data by ID
    Then I should return Updated post Data

  Scenario:Verify Delete User
    Given I should perform Delete post Data by id
    Then i Should return Deleted data for the id





