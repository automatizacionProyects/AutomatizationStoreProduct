package org.example.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.AddProductsToCar;

import java.util.List;
import java.util.stream.Collectors;

public class ValidateTotalAmount implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        List<WebElementFacade> priceElements = AddProductsToCar.PRODUCT_PRICES.resolveAllFor(actor);


        List<Integer> prices = priceElements.stream()
                .map(WebElementFacade::getText)
                .map(price -> price.replaceAll("[^\\d]", ""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        int calculatedTotal = 0;
        for (int price : prices) {
            calculatedTotal += price;  // Sumamos directamente los valores
        }


        String displayedTotalText = AddProductsToCar.TOTAL_PRICE.resolveFor(actor).getText().replaceAll("[^\\d]", "");
        int displayedTotal = Integer.parseInt(displayedTotalText);

        return calculatedTotal == displayedTotal;


    }

    public static  ValidateTotalAmount isCorrect(){
        return  new ValidateTotalAmount();
    }

}
