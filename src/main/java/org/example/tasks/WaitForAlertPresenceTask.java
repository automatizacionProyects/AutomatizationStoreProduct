package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class WaitForAlertPresenceTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        try {
            long timeout = 10000;
            long pollingInterval = 500;
            long endTime = System.currentTimeMillis() + timeout;

            while (System.currentTimeMillis() < endTime) {
                try {
                    driver.switchTo().alert();
                    System.out.println("Alerta detectada");
                    return;
                } catch (Exception e) {
                    Thread.sleep(pollingInterval);
                }
            }
            throw new RuntimeException("La alerta no apareció dentro del tiempo esperado.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Error al esperar la alerta: " + e.getMessage());
        }
    }

    public static WaitForAlertPresenceTask waitForAlert() {
        return instrumented(WaitForAlertPresenceTask.class);
    }
}
