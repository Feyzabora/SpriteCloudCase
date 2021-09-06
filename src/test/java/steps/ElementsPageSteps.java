package steps;

import io.cucumber.java.en.*;
import pages.ElementsPage;

public class ElementsPageSteps {

    ElementsPage elementsPage = new ElementsPage();

    @Given("I click element type {}")
    public void clickType(String type){elementsPage.clickSubElement(type);}

    @Given("I enter the username {}")
    public void enterName(String userName){elementsPage.fillInput(elementsPage.nameInput,userName);}

    @Given("I enter the email {}")
    public void enterEmail(String email){elementsPage.fillInput(elementsPage.emailInput,email);}

    @Given("I enter current address {}")
    public void iEnterCurrentAddress(String address){elementsPage.fillInput(elementsPage.addressInput,address);}

    @Given("I enter permanent address {}")
    public void iEnterPermanentAddress(String address){elementsPage.fillInput(elementsPage.permanentAddressInput,address);}

    @Given("I click submit button")
    public void iClickToSubmitButton() {elementsPage.clickElement(elementsPage.submitButton);}

    @Given("I verify name output to be {}")
    public void verifyNameOutputText(String name){elementsPage.verifyNameOutput(name);}

    @Given("I verify email output to be {}")
    public void verifyEmailOutputText(String email){elementsPage.verifyEmailOutput(email);}

    @Given("I verify current address output to be {}")
    public void verifyCurrentAddressOutputText(String currentAddress){elementsPage.verifyCurrentAddressOutput(currentAddress);}

    @Given("I verify permanent address output to be {}")
    public void verifyPermanentAddressOutputText(String permanentAddress){elementsPage.verifyPermanentAddressOutput(permanentAddress);}

    @Given("I click checkbox")
    public void iClickToCheckBox() {elementsPage.clickElement(elementsPage.checkBox);}

    @Given("I verify checkbox is checked: {}")
    public void  verifyCheckBox(Boolean state) {elementsPage.verifyCheckboxToBe(elementsPage.checkBox, state);}
}