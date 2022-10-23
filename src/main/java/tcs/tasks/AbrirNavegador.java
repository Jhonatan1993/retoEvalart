package tcs.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import tcs.model.DataEvalart;
import tcs.userinterface.AbrirPaginaEvalartApp;

public class AbrirNavegador implements Task {

    private DataEvalart dataEvalart;

    public AbrirNavegador(DataEvalart dataEvalart){this.dataEvalart = dataEvalart;}
    private static AbrirPaginaEvalartApp abrirPaginaEvalartApp;
    public static Performable pagina(DataEvalart dataEvalart){return Tasks.instrumented(AbrirNavegador.class, dataEvalart);}

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(abrirPaginaEvalartApp)
        );}
}
