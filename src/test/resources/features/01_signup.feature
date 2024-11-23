Feature: Signup
@signup
Scenario: As a user I want to register in the application
  Given As a user I navigate to the website
  When I register with username "enlaceOperativo" and password "enlaceOperativo1234"
  Then The user should see an alert with the message registration successful



