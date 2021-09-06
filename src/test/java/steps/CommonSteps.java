package steps;

import io.cucumber.java.en.*;
import io.cucumber.java.*;
import utils.Utilities;

public class CommonSteps extends Utilities {

    @Before
    public void start(){init();}

    @After
    public void kill(){teardown();}

    @Given("I navigate to {}")
    public void navigate(String url){ driver.get("https://"+url); }

    @Then("I wait for {} seconds")
    public void waitFor(int duration){
        try {Thread.sleep(duration* 1000L);}
        catch (InterruptedException e) {e.printStackTrace();}
    }
}