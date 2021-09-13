package steps;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.en.*;
import io.cucumber.java.*;
import io.restassured.response.Response;
import utils.ApiUtilities;
import utils.Utilities;
import java.io.File;

public class CommonSteps extends Utilities {

    ApiUtilities apiUtils = new ApiUtilities();
//Let me explain how the framework works.
    @Before
    public void start(){init();} //The driver initialized with the before tag and killed with the after tag

    @After
    public void kill(Scenario scenario){        // Uploads report to Calliope & kills driver

        File screenShot = null;

        if (scenario.isFailed()){
            System.out.println("Scenario named "+scenario.getName()+" failed!");
            String name = captureScreen(scenario.getName());
            System.out.println("Screenshots/"+name);
            screenShot = new File("Screenshots/"+name);
            System.out.println("See Screenshots folder for the ss");
        }

        try {

            apiUtils.url = "app.calliope.pro/api/v2/";
            apiUtils.uri = "profile/"+ 3682 +"/import";

            File report = new File("target/surefire-reports/testng-results.xml");
            if (report.exists()){
                Response response = apiUtils.uploadReport(report,screenShot,scenario);
                if (response.getStatusCode() == 201){
                    String reportUrl = (String) ApiUtilities.serverResponse.get("report_url");
                    System.out.println("\033[1;90m"+"The test report on Calliope can be accessed from: \n" + reportUrl+"\033[0m");
                }
            }
        }
        catch (Exception ignored) {
            teardown();
        }
        teardown(); // Kills driver
    }

    @Given("I navigate to {}")
    public void navigate(String url){ driver.get("https://"+url); }

    @Then("I wait for {} seconds")
    public void waitFor(int duration){
        try {Thread.sleep(duration* 1000L);}
        catch (InterruptedException e) {e.printStackTrace();}
    }
}