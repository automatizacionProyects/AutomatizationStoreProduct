package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.example.ui.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginTask implements Task {

    private final String username;
    private  final String password;

    public LoginTask(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Click.on(LoginPage.BUTTON_LOGIN_MENU),
                    Enter.theValue(username).into(LoginPage.INPUT_USERNAME),
                    Enter.theValue(password).into(LoginPage.INPUT_PASSWORD),
                    Click.on(LoginPage.BUTTON_LOGIN)
            );
            Thread.sleep(9000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }


    }

    public static LoginTask loginTask(String username, String password){
        return instrumented(LoginTask.class, username, password);
    }
}
