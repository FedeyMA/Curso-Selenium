package steps;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PaginaCursos;
import pages.PaginaFundamentosTesting;
import pages.PaginaPrincipal;
import pages.PaginaRegistro;

public class FreeRangeSteps {

    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos cursosPage = new PaginaCursos();
    PaginaFundamentosTesting fundamentosPage = new PaginaFundamentosTesting();
    PaginaRegistro registro = new PaginaRegistro();
    
    @Given("I navigate to www.freerangetesters.com")
    public void iNavigateToFRT(){
        landingPage.navigateToFreeRangeTesters();
    }

    @When("I go to {} using the navigation bar")
    public void navigationBarUse(String section){
        landingPage.clickOnSectionNavigationBar(section);
    }

    @When("^(?:I|The user|The client) selects? Elegir Plan$")
    public void selectElegirPlan(){
        landingPage.clickOnElegirUnPlanButton();
    }

    @And("^(?:I|The user|The client) (select|selects) Introduccíon al Testing$")
    public void navigateToIntro(){
        cursosPage.clickFundamentosTestingLink();
        fundamentosPage.clickIntroduccionTestingLink();
    }

    @Then("^(?:I|The user|The client) can validate the options in the checkout page$")
    public void validateCheckoutPlans(){
        List<String> lista = registro.returnPlanDropdownValues();
        List<String> listaEsperada = Arrays.asList("Academia: $17.99 / mes • 12 productos", "Academia: $176 / año • 12 productos", "Free: Gratis • 3 productos");

        assertEquals(listaEsperada, lista);
    }


}
