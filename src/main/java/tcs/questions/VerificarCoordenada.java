package tcs.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Enter;
import tcs.model.DataCoordenada;
import tcs.model.DataEvalart;
import tcs.userinterface.LoginPage;
import tcs.util.Utilities;

import java.util.List;

public class VerificarCoordenada implements Question<Boolean> {

    private DataEvalart dataEvalart;
    private Utilities utilities;

    public VerificarCoordenada(DataEvalart dataEvalart) {
        this.dataEvalart = dataEvalart;
        utilities = new Utilities(dataEvalart);
    }

    public static VerificarCoordenada coordenada(DataEvalart dataEvalart) {return new VerificarCoordenada(dataEvalart);}
    @Override
    public Boolean answeredBy(Actor actor) {

        List<DataCoordenada> coordenadas = utilities.obtenerCoordenada(actor);
        DataCoordenada coordenada = utilities.sumarCoordenada(coordenadas);
        int posicion = coordenada.getEjeY()*12 + coordenada.getEjeX()+1;
        utilities.cliquearJS(posicion);

        System.out.println(coordenada.getEjeX() +","+ coordenada.getEjeY());
        System.out.println(posicion);
        return true;

    }
}
