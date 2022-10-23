package tcs.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    public static final Target USERNAME = Target.the("Ingresar nombre de usuario").located(By.xpath("//input[@name='username']"));
    public static final Target PASSWORD = Target.the("Ingresar contraseña").located(By.xpath("//input[@name='password']"));
    public static final Target BTN_ENVIAR = Target.the("Boton Enviar").located(By.xpath("//button[contains(text(),'Enviar')]"));



}
