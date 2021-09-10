package steps;

import io.cucumber.java.en.Given;
import pages.ElementsPage;
import pages.InteractionsPage;
import utils.Utilities;

public class InteractionsPageSteps {

    InteractionsPage interactionsPage = new InteractionsPage();

    @Given("I click grid")
    public void iClickToGridSection() {interactionsPage.clickElement(interactionsPage.grid);}

    @Given("I drag {} to {}")
    public void dragAndDrop(String number1,String number2) {interactionsPage.dragDrop(number1,number2);}

    @Given("I select number {} and {} cards")
    public void clickType(String type,String type2){interactionsPage.clickGridCards(type,type2);}

    @Given("I click drag {} to {}")
    public void clickBoxes(String type,String type2){interactionsPage.dragDropBoxees(type,type2);}


}