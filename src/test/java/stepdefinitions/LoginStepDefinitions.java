package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import org.example.questions.EmptyFields;
import org.example.tasks.AcceptAlertTask;
import org.example.tasks.LoginTask;
import org.example.tasks.SignupTask;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginStepDefinitions {

    @When("As a user I want to log in with username {string} and password {string}")
    public void as_a_user_i_want_to_log_in_with_username_and_password(String username, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginTask.loginTask(username, password)
        );

    }

    @When("the user attempts to log in with empty fields username {string} and passowrd {string}")
    public void the_user_attempts_to_log_in_with_empty_fields(String username, String password) {
        AcceptAlertTask alertTask = AcceptAlertTask.enPantalla();
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginTask.loginTask(username, password),
                alertTask

        );

        OnStage.theActorInTheSpotlight().remember("alertTask", alertTask);
    }
    @Then("the user should see an alert with the message {string}")
    public void the_user_should_see_an_alert_with_the_message(String expectedMessage) {
        AcceptAlertTask alertTask = OnStage.theActorInTheSpotlight().recall("alertTask");
        String actualMessage = EmptyFields.from(alertTask).answeredBy(OnStage.theActorInTheSpotlight());

        // Validar el texto de la alerta
        assertThat("El texto de la alerta no coincide", actualMessage, equalTo(expectedMessage));
    }

    @When("the user attempts to register  with empty fields username {string} and passowrd {string}")
    public void the_user_attempts_to_register_with_empty_fields_username_and_passowrd(String username, String password) {
        AcceptAlertTask alertTask = AcceptAlertTask.enPantalla();
        OnStage.theActorInTheSpotlight().attemptsTo(
                SignupTask.loginTask(username, password),
                alertTask

        );

        OnStage.theActorInTheSpotlight().remember("alertTask", alertTask);
    }


}
