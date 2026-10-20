Feature: Authentication login/register

    Scenario: Register with valid customer details
        Given the customer opens the e-commerce home page
        When the customer opens the registration page
        And user enter valid details email "shwetadhumal619@gmail.com", phone "9874563218", username "shwetagg879", password "Shweta@123"
