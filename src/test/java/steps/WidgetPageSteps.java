package steps;

import io.cucumber.java.en.Given;
import pages.WidgetsPage;

public class WidgetPageSteps {

    WidgetsPage widgetsPage = new WidgetsPage();

    @Given("I click date picker")
    public void iClickToDatePicker() {widgetsPage.clickElement(widgetsPage.datePicker);}

    @Given("I click month picker")
    public void iClickToMonthPicker() {widgetsPage.clickElement(widgetsPage.monthPicker);}

    @Given("I select {} from date picker")
    public void clickType(String type){widgetsPage.selectMonth(type);}

    @Given("I click year {} from date picker")
    public void selectYearFromDatePicker(String type){widgetsPage.selectYear(type);}

    @Given("I click day {} from date picker")
    public void selectTheDay(String dayNumber){widgetsPage.selectDay(dayNumber);}

    @Given("I click day 27")
    public void iClickToDay27() {widgetsPage.clickElement(widgetsPage.day27);}

    @Given("I click menu type {}")
    public void clickMenu(String type){widgetsPage.selectMenu(type);}

    @Given("I select color type {}")
    public void selectColor(String type){widgetsPage.selectColorType(type);}

    @Given("I click select value type")
    public void selectValue(){widgetsPage.multipleSelect();}

    @Given("I click dropdown {}")
    public void clickList(String type){widgetsPage.clickFromList(type);}

    @Given("I click group option from dropdown {}")
    public void clickOption(String type){widgetsPage.clickOptionFromList(type);}

    @Given("I remove colors")
    public void iRemoveColor() {widgetsPage.removeTags();}

    @Given("I click car type {}")
    public void selectCar(String type){widgetsPage.selectCarType(type);}

    @Given("I verify dropdown to be {}")
    public void verifyNameOutputText(String name){widgetsPage.verifySelectedRow(name);}

    @Given("I verify removed tags")
    public void verifyRemovedTags(){widgetsPage.verifyRemovedTags();}

    @Given("I verify color to be {}")
    public void verifyColorType(String name){widgetsPage.verifyColor(name);}

    @Given("I verify car type to be {}")
    public void verifyCarBrand(String name){widgetsPage.verifyCarType(name);}

    @Given("I verify date {}")
    public void verifyExactDate(String name){widgetsPage.verifyDate(name);}


}