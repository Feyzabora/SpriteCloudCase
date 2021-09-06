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

    @Given("I click day {} from date picker")
    public void selectTheDay(String dayNumber){widgetsPage.selectDay(dayNumber);}

    @Given("I click day 27")
    public void iClickToDay27() {widgetsPage.clickElement(widgetsPage.day27);}

    @Given("I click menu type {}")
    public void clickMenu(String type){widgetsPage.selectMenu(type);}

}