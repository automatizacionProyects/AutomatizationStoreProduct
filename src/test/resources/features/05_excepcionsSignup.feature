Feature: Exceptions Signup
  @EmptySingupFields
  Scenario: As a user I want to register with empty fields
    Given As a user I navigate to the website
    When the user attempts to register  with empty fields username "fdsdfds" and passowrd ""
    Then the user should see an alert with the message "Please fill out Username and Password."

    @theUserAlredyExist
    Scenario: As a user I want to register with an existing user
      Given As a user I navigate to the website
      When the user attempts to register  with empty fields username "aleman97" and passowrd "12345"
      Then the user should see an alert with the message "This user already exist."
