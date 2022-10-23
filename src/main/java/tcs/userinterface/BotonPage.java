package tcs.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BotonPage extends PageObject {

    public static final Target COORDENADAS = Target.the("Seleccionar coordenadas").located(By.xpath("//p[@class='text-center text-xl font-bold']"));
    public static final Target BTN_OPTION = Target.the("Seleccionar boton").located(By.xpath("//button[@name='button_option']"));
    public static final Target INPUT_SUMA = Target.the("Ingresar la suma").located(By.xpath("//input[@name='modal_answer']"));

}
