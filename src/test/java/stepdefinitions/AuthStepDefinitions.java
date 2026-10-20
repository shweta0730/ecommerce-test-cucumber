package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageobject.AuthPageObject;

public class AuthStepDefinitions {

    private final AuthPageObject registerPage = new AuthPageObject();

    @Given("the customer opens the e-commerce home page")
    public void openHomePage() throws InterruptedException {
        registerPage.open();
    }

    @When("the customer opens the registration page")
    public void openRegistrationPage(){
        registerPage.openRegistrationPage();
    }

    @And("user enter valid details email {string}, phone {string}, username {string}, password {string}")
    public void enterRegistrationDetails(String email, String phone, String username, String password){
        registerPage.enterValidUserDetailsForRegistration(email,phone,username,password);
    }
}
