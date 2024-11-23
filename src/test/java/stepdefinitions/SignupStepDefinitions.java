package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.example.tasks.AcceptAlertTask;
import org.example.tasks.SignupTask;

public class SignupStepDefinitions {

    @Given("As a user I navigate to the website")
    public void as_a_user_i_navigate_to_the_website() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("User").wasAbleTo(Open.url("https://demoblaze.com/"));
    }
    @When("I register with username {string} and password {string}")
    public void i_register_with_username_and_password(String userName, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SignupTask.loginTask(userName, password)
        );
    }

    @Then("The user should see an alert with the message registration successful")
    public void the_user_should_see_an_alert_with_the_message_registration_successful() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AcceptAlertTask.enPantalla()
        );
    }

}
