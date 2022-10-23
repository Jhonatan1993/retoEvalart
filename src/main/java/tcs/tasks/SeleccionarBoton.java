package tcs.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import tcs.model.DataEvalart;
import tcs.userinterface.BotonPage;

public class SeleccionarBoton implements Task {

    private DataEvalart dataEvalart;
    public SeleccionarBoton(DataEvalart dataEvalart){this.dataEvalart = dataEvalart;}
    public static BotonPage botonPage;

    public static Performable boton(DataEvalart dataEvalart) {return Tasks.instrumented(Login.class, dataEvalart);}

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BotonPage.BTN_OPTION),
                Enter.theValue(dataEvalart.getSuma()).into(BotonPage.INPUT_SUMA)
        );
    }
}
