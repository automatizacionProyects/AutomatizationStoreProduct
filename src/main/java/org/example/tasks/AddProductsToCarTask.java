package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.AddProductsToCar;
import org.openqa.selenium.By;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProductsToCarTask implements Task {
    private final List<String> productsNames;

    public AddProductsToCarTask(List<String> productsNames){
        this.productsNames = productsNames;

    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            for (String productName : productsNames){

                actor.attemptsTo(
                        WaitUntil.the(AddProductsToCar.PRODUCT.of(productName), WebElementStateMatchers.isVisible()).forNoMoreThan(60).seconds(),
                        WaitUntil.the(AddProductsToCar.PRODUCT.of(productName), WebElementStateMatchers.isClickable()).forNoMoreThan(60).seconds(),
                        Click.on(AddProductsToCar.PRODUCT.of(productName))
                );



                actor.attemptsTo(
                        WaitUntil.the(AddProductsToCar.ADD_TO_CART, WebElementStateMatchers.isClickable()).forNoMoreThan(60).seconds(),
                        Click.on(AddProductsToCar.ADD_TO_CART),
                        WaitForAlertPresenceTask.waitForAlert(),
                        AcceptAlertTask.enPantalla()
                );



                actor.attemptsTo(
                        WaitUntil.the(AddProductsToCar.HOME, WebElementStateMatchers.isClickable()).forNoMoreThan(60).seconds(),
                        Click.on(AddProductsToCar.HOME)
                );

            }
            Thread.sleep(9000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }


    }

    public static AddProductsToCarTask addProductsToCarTask(List<String> productsNames){
        return new AddProductsToCarTask(productsNames);
    }
}
