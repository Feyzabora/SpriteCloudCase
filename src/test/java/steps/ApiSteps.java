package steps;

import io.cucumber.java.en.Given;
import pages.Api;

public class ApiSteps {

    Api api = new Api();

    @Given("I delete pet {} which has {} id number.")
    public void iClickToSubmitButton(String name,String id) {api.deletePet(name,id);}

}
