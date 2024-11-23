package org.example.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SignupPage {

    public static  final Target BUTTON_SIGNUP = Target.the("Signup Button").located(By.id("signin2"));
    public  static final Target INPUT_USERNAME = Target.the("Username input").located(By.id("sign-username"));
    public static  final  Target INPUT_PASSWORD = Target.the("Password input").located(By.id("sign-password"));
    public static  final Target BUTTON_SIGNUP_REGISTER = Target.the("Button singup").located(By.xpath("//button[@type='button' and @class='btn btn-primary' and text()='Sign up']"));

}
