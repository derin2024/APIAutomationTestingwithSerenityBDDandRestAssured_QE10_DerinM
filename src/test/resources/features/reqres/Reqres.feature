Feature: Reqres API Automation Testing QE-10
  @Latihan
  Scenario Outline: Get list users with valid parameter page
    Given Get list users with valid parameter page <page>
    When Send get lists users
    Then Status code should be 200 OK
    And Response body page should be <page>
    And Validate get list user JSON Schema
    Examples:
      | page |
      |1     |
      |2     |
  @Latihan
  Scenario: Post create new user with valid json
    Given Post create user with valid json
    When Send post create user
    Then Status code should be 201 Created
    And Response body name was "Derin" and job was "QA Engineer"
    And Validate post create user JSON Schema
  @Latihan
  Scenario Outline: Put update user with valid json and id
    Given Put update user with valid json and id <id>
    When Send put update user
    Then Status code should be 200 OK
    And Response Put Update body name was "Derin" and job was "QA Engineer"
    And Validate put update user JSON Schema
  Examples:
    | id |
    |1   |
    |2   |
    |3   |
  @Latihan
  Scenario Outline: Delete user with valid parameter id
    Given Delete user with valid id <id>
    When Send delete user
    Then Status code should be 204 No Content
  Examples:
    | id |
    |1   |
    |2   |
  @Tugas
  Scenario: Login user with valid json
    Given Login user
    When Send login user
    Then Status code should be 200 OK
    And Response body token should be "QpwL5tke4Pnpja7X4"
    And Validate login user JSON Schema
  @Tugas
  Scenario: Login unsuccesful with invalid body json
    Given Login user unsuccesful
    When Send login user unsuccesful
    Then Status code should be 400 Bad Request
    And Response body error should be "Missing password"
    And Validate login user unsuccesful JSON Schema
  @Tugas
  Scenario: Register unsuccesful with invalid body json
    Given Register user unsuccesful
    When Send register user unsuccesful
    Then Register unsuccessful Status code should be 400 Bad Request
    And Register unsuccessful Response body error should be "Missing password"
    And Validate register user unsuccesful JSON Schema
  @Tugas
  Scenario: Get single user by id with valid parameter id
    Given Get user by Id 2
    When Send get user by Id
    Then Get single user Status code should be 200 OK
    And Response body id should be 2 and first name should be "Janet" and last name should be "Weaver"
    And Validate get single user JSON Schema
  @Tugas
  Scenario: Patch update user success with valid id and json
    Given Patch update user with valid json and id 2
    When Send patch update user
    Then Status code Patch update user should be 200 OK
    And Response body Patch update user name should be "morpheus" and job should be "zion resident"
    And Validate patch update user JSON Schema
  @Tugas
  Scenario Outline: Invalid Delete user with invalid id
    Given Delete User with invalid "<id>" id
    When Send delete user with invalid id
    Then Delete user with invalid id Status code should be 204 No Content
   Examples:
     | id |
     |a   |
     |@   |
