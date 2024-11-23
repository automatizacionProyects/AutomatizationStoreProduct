package org.example.ui;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class LoginPage {
    public static  final Target BUTTON_LOGIN_MENU = Target.the("Log in Button menu").located(By.id("login2"));
    public static  final Target INPUT_USERNAME = Target.the("Input username").located(By.id("loginusername"));
    public  static  final  Target INPUT_PASSWORD = Target.the("Input password").located(By.id("loginpassword"));
    public static  final  Target BUTTON_LOGIN = Target.the("Button Login").located( By.xpath("//button[@type='button' and @class='btn btn-primary' and text()='Log in']"));
}
