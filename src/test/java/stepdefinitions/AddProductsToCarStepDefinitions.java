package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import org.example.questions.ValidateAddedProduct;
import org.example.questions.ValidateTotalAmount;
import org.example.tasks.AcceptAlertTask;
import org.example.tasks.AddProductsToCarTask;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

import java.util.List;

public class AddProductsToCarStepDefinitions {

    @When("Add the following products to your cart")
    public void add_the_following_products_to_your_cart(List<String> products) {

        /*products.asList().forEach(product ->
                OnStage.theActorInTheSpotlight().attemptsTo(
                        AddProductsToCarTask.addProductsToCarTask(product),
                       AcceptAlertTask.enPantalla()

                ));*/
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddProductsToCarTask.addProductsToCarTask(products)
                //AcceptAlertTask.enPantalla()
        );
    }

    @Then("the user should see the products in the cart")
    public void the_user_should_see_the_products_in_the_cart(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedProducts = dataTable.asList(String.class);
        List<String> actualProducts = OnStage.theActorInTheSpotlight().asksFor(ValidateAddedProduct.displayed());
        // Agregar logs para depuración
        System.out.println("Productos esperados: " + expectedProducts);
        System.out.println("Productos actuales: " + actualProducts);

        assertThat("Los productos en el carrito no coinciden", actualProducts, containsInAnyOrder(expectedProducts.toArray()));

    }

    @Then("The total amount of the products should match the sum of their prices")
    public void the_total_amount_of_the_products_should_match_the_sum_of_their_prices() {
        Boolean isTotalCorrect = OnStage.theActorInTheSpotlight().asksFor(ValidateTotalAmount.isCorrect());

        assertThat("El monto total no coincide con la suma de los precios obtenidos", isTotalCorrect, is(true));

    }


}
