package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.example.tasks.AcceptAlertTask;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class EmptyFields implements  Question<String>  {
    private final AcceptAlertTask task;

            public EmptyFields(AcceptAlertTask task){
                this.task= task;
            }

    @Override
    public String answeredBy(Actor actor) {
                return task.getAlertText();

    }

    public static EmptyFields from(AcceptAlertTask task){
        return new  EmptyFields(task);
    }
}
