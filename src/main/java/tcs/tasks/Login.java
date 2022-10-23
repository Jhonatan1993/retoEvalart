package tcs.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import tcs.model.DataEvalart;
import tcs.userinterface.LoginPage;

public class Login implements Task {

    private DataEvalart dataEvalart;
    public Login(DataEvalart dataEvalart){this.dataEvalart = dataEvalart;}
    public static LoginPage loginPage;
    public static Performable credenciales(DataEvalart dataEvalart){return Tasks.instrumented(Login.class, dataEvalart);}
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(dataEvalart.getUsername()).into(LoginPage.USERNAME),
                Enter.theValue(dataEvalart.getPassword()).into(LoginPage.PASSWORD),
                Click.on(LoginPage.BTN_ENVIAR)
        );
    }
}
