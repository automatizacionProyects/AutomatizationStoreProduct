package org.example.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.tasks.AcceptAlertTask;
import org.example.ui.AddProductsToCar;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ValidateAddedProduct implements Question<List<String>> {

    @Override
    public List<String> answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(AddProductsToCar.CART, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(20).seconds(),
                Click.on(AddProductsToCar.CART)
        );


        int expectedProductCount = 7;
        List<WebElementFacade> productElements = List.of();

        for (int attempts = 0; attempts < 8; attempts++) {
            actor.attemptsTo(
                    WaitUntil.the(AddProductsToCar.PRODUCT_NAMES, WebElementStateMatchers.isVisible())
                            .forNoMoreThan(10).seconds()
            );

            productElements = AddProductsToCar.PRODUCT_NAMES.resolveAllFor(actor);


            productElements.forEach(element -> {
                System.out.println("Elemento HTML: " + element.getAttribute("outerHTML"));
                System.out.println("Texto encontrado: " + element.getText());
            });

            if (productElements.size() == expectedProductCount) {
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        return productElements.stream()
                .map(WebElementFacade::getText)
                .peek(product -> System.out.println("Producto encontrado: " + product))
                .collect(Collectors.toList());


    }

    public static ValidateAddedProduct displayed() {
        return new ValidateAddedProduct();
    }
}
