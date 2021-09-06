package steps;

import io.cucumber.java.en.*;
import pages.HomePage;

public class HomePageSteps {

    HomePage homePage = new HomePage();

    @Then("I click card named {}")
    public void clickCard(String card){homePage.clickHomeCard(card);}
}