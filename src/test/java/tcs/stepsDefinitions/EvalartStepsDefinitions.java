package tcs.stepsDefinitions;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import tcs.model.DataEvalart;
import tcs.questions.VerificarCoordenada;
import tcs.tasks.AbrirNavegador;
import tcs.tasks.Login;
import tcs.tasks.SeleccionarBoton;


public class EvalartStepsDefinitions {

    @Before
    public void iniciarEscenario(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^que Jhonatan ingresa a la pagina evalartapp$")
    public void queJhonatanQuiereIngresarALaPaginaEvalartapp(DataTable dataTable) {
        OnStage.theActorCalled("Jhonatan").wasAbleTo(AbrirNavegador.pagina(DataEvalart.setDataEvalarts(dataTable).get(0)),
                Login.credenciales(DataEvalart.setDataEvalarts(dataTable).get(0)));
    }

    @When("^el ingresa selecciona un boton$")
    public void elIngresaSeleccionaUnBoton(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(SeleccionarBoton.boton(DataEvalart.setDataEvalarts(dataTable).get(0)));
    }

    @Then("^el verifica que el boton sea el correcto$")
    public void elVerificaQueElBotonSeaElCorrecto(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(VerificarCoordenada.coordenada(DataEvalart.setDataEvalarts(dataTable).get(0))));
    }


}
