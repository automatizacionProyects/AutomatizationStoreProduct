Feature: Exceptions Login
  @EmptyLoginFields
  Scenario: As a user I want to log in with empty fields
    Given As a user I navigate to the website
    When the user attempts to log in with empty fields username "" and passowrd ""
    Then the user should see an alert with the message "Please fill out Username and Password."

  @UserDoesNotExist
  Scenario: As a user I want to log in with empty fields
    Given As a user I navigate to the website
    When the user attempts to log in with empty fields username "dkdkdkdk" and passowrd "ksksksksksls"
    Then the user should see an alert with the message "User does not exist."


  @PasswordWrong
  Scenario: As a user I want to log in with empty fields
    Given As a user I navigate to the website
    When the user attempts to log in with empty fields username "aleman97" and passowrd "ksksksksksls"
    Then the user should see an alert with the message "Wrong password."