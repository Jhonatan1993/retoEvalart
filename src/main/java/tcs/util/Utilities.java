package tcs.util;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import tcs.model.DataCoordenada;
import tcs.model.DataEvalart;
import tcs.userinterface.BotonPage;
import tcs.userinterface.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class Utilities extends PageObject {

    private static DataEvalart dataEvalart;
    public Utilities(DataEvalart dataEvalart) {
        this.dataEvalart = dataEvalart;
    }


    public List<DataCoordenada> obtenerCoordenada(Actor actor) {
        String[] verificarData = Text.of(BotonPage.COORDENADAS).answeredBy(actor).replaceAll("[()]","").split("\\.");
        List<DataCoordenada> coordenadas = new ArrayList<DataCoordenada>();

        for(String coordenada : verificarData)
        {
            int x = Integer.parseInt(coordenada.split(",")[0]);
            int y = Integer.parseInt(coordenada.split(",")[1]);

            coordenadas.add(new DataCoordenada(x,y));
        }
        return coordenadas;
    }

    public DataCoordenada sumarCoordenada(List<DataCoordenada> coordenadas){

        int x = 0, y = 0;
        for (DataCoordenada coordenada : coordenadas){
            x += coordenada.getEjeX();
            y += coordenada.getEjeY();
        }

        return new DataCoordenada(x,y);
    }
    public void saleccionarOpcion(Actor actor, int posicion) {

        String xpath = "//button[@type='button'][%s]";
        System.out.println(String.format(xpath,posicion));
        Target select_order = Target.the("Seleccionar orden").located(By.xpath(String.format(xpath, posicion)));
        actor.attemptsTo(Click.on(select_order));
    }

    public void cliquearJS(int posicion) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("document.querySelector('body > div.flex.flex-row.p-3.justify-evenly > form > div > button:nth-child("+ posicion +")').click()");
    }


}
