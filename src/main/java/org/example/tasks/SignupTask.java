package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.example.ui.SignupPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SignupTask implements Task {

private final String username;
private  final  String password;

    public SignupTask(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Click.on(SignupPage.BUTTON_SIGNUP),
                    Enter.theValue(username).into(SignupPage.INPUT_USERNAME),
                    Enter.theValue(password).into(SignupPage.INPUT_PASSWORD),
                    Click.on(SignupPage.BUTTON_SIGNUP_REGISTER)
            );
            Thread.sleep(9000);

        }catch (InterruptedException e){
            Thread.currentThread().interrupt();

        }



    }

    public static SignupTask loginTask(String username, String password){
        return instrumented(SignupTask.class, username, password);
    }
}
