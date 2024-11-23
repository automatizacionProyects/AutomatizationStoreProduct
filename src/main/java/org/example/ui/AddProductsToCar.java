package org.example.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AddProductsToCar {

    public static final Target PRODUCT = Target.the("Product link")
            .locatedBy("//a[text()='{0}']");
    public static final Target ADD_TO_CART = Target.the("Add to cart button")
            .located(By.xpath("//a[text()='Add to cart']"));
    public static final Target HOME = Target.the("Home link")
            .located(By.xpath("//*[@id='navbarExample']/ul/li[1]/a"));
    public static final Target CART = Target.the("shopping cart")
            .locatedBy("#cartur");
    public static final Target PRODUCT_NAMES = Target.the("Product names in cart")
            .located(By.xpath("//*[@id='tbodyid']/tr/td[2]"));

    public static final Target PRODUCT_PRICES = Target.the("Prices of products in the cart")
            .locatedBy("//*[@id='tbodyid']//td[3]");
    public static final Target TOTAL_PRICE = Target.the("Total cart price")
            .locatedBy("#totalp");


}
