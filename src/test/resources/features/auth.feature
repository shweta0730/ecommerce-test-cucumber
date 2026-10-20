Feature: Authentication login/register

    Scenario: Register with valid customer details
        Given the customer opens the e-commerce home page
        When the customer opens the registration page
        And user enter valid details email "shwetadhumal6121@gmail.com", phone "9879566218", username "shweta879", password "Shweta@123"
        And Click on create account button
        Then verify user is registered successfully