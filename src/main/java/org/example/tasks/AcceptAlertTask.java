package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Switch;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class AcceptAlertTask implements Task {
    private   String textAlerta;


    public String getAlertText() {
        return textAlerta;
    }

    WebDriver driver = getProxiedDriver();
    @Override
    public <T extends Actor> void performAs(T actor) {
        Alert alert = driver.switchTo().alert();
        textAlerta = alert.getText();
        alert.accept();
    }

    public static AcceptAlertTask enPantalla() {
        return instrumented(AcceptAlertTask.class);
    }
}
