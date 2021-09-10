package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.Utilities;
import java.util.List;

public class WidgetsPage extends Utilities {

    @FindBy(css = "[id=\"datePickerMonthYearInput\"]")
    public WebElement datePicker;

    @FindBy(css = "[class*='react-datepicker__month-dropdown-container']")
    public WebElement monthPicker;

    @FindBy(css = "[class=\"react-datepicker__month-select\"] option")
    public List<WebElement> months;

    @FindBy(css = "[class=\"react-datepicker__year-select\"] option")
    public List<WebElement> years;

    @FindBy(css = "[class=\"react-datepicker__month\"] div")
    public List<WebElement> days;

    @FindBy(css = "[class=\"react-datepicker__day react-datepicker__day--027\"]")
    public WebElement day27;

    @FindBy(css = "[class=\"nav-menu-container\"] a")
    public List<WebElement> menus;

    @FindBy(css = "[id=\"oldSelectMenu\"] option")
    public List<WebElement> selectColor;

    @FindBy(css = "[name=\"cars\"] option")
    public List<WebElement> selectCars;

    @FindBy(css = "[class=\"css-xb97g8\"]")
    public List<WebElement> colorTags;

    @FindBy(css = "[class=\" css-1uccc91-singleValue\"]")
    public List<WebElement> dropDawns;

    @FindBy(css = "[class=\" css-1wa3eu0-placeholder\"]")
    public List<WebElement> drapDown1;

    @FindBy(css = "[class*=\"menu\"] [class*='option']")
    public List<WebElement> groupOptions;

    @FindBy(css = "[id='datePickerMonthYearInput']")
    public WebElement datePickerDate;

    public void clickFromList(String type){
        for (WebElement row: drapDown1) {
            if (row.getText().contains(type)){
                clickElement(row);
                return;
            }
        }
        Assert.fail("Could not find element type: " + type);
    }

    public void clickOptionFromList(String type){
        for (WebElement option: groupOptions) {
            if (option.getText().contains(type)){
                clickElement(option);
                return;
            }
        }
        Assert.fail("Could not find element type: " + type);
    }

    public void removeTags(){
        while (colorTags.size() > 0){
            clickElement(colorTags.get(0));
            waitFor(0.5);
        }
    }

    public void selectMonth(String monthName) {
        for (WebElement month : months) {
            System.out.println(month.getText());
            if (month.getText().contains(monthName)) {
                clickElement(month);
                clickElement(monthPicker);
                return;
            }
        }
        Assert.fail("Could not find element type: " + monthName);
    }

    public void selectYear(String yearName) {
        for (WebElement year : years) {
            System.out.println(year.getText());
            if (year.getText().contains(yearName)) {
                clickElement(year);
                clickElement(monthPicker);
                return;
            }
        }
        Assert.fail("Could not find element type: " + yearName);
    }

    public void selectDay(String dayNumber) {
        for (WebElement day : days) {
            System.out.println(day.getText());
            if (day.getText().contains(dayNumber)) {
                clickElement(day);
                return;
            }
        }
        Assert.fail("Could not find element type: " + dayNumber);
    }

    public void selectMenu(String menuType) {
        Actions actions = new Actions(driver);
        for (WebElement menu : menus) {
            System.out.println(menu.getText());
            actions.moveToElement(menu).perform();
            if (menu.getText().contains(menuType)) {
                return;
            }
        }
        Assert.fail("Could not find element type: " + menuType);
    }

    public void selectColorType(String type) {
        for (WebElement colorType : selectColor) {
            if (colorType.getText().contains(type)) {
                clickElement(colorType);
                return;
            }
        }
        Assert.fail("Could not find element type: " + type);
    }

    public void selectCarType(String type) {
        for (WebElement carType : selectCars) {
            if (carType.getText().contains(type)) {
                clickElement(carType);
                return;
            }
        }
        Assert.fail("Could not find element type: " + type);
    }

    public void verifySelectedRow(String text) {
        for (WebElement dropdownValue : dropDawns) {
            if (dropdownValue.getText().contains(text)) {
                System.out.println(text + "option is selected from dropdown");
                return;
            }
        }
        Assert.fail("Could not verify dropdown selection to be "+text);
    }

    public void verifyRemovedTags(){
        if (colorTags.size()==0){
            System.out.println("Tags removed successfully.");
        }
        else {
            System.out.println("Tags has not been removed successfully.");
        }
    }

    public void verifyColor(String text) {
        for (WebElement whichColor : selectColor) {
            if (whichColor.getText().contains(text)) {
                System.out.println(text + " color is selected from dropdown");
                return;
            }
        }
        Assert.fail("Could not verify color selection to be "+text);
    }
    public void verifyCarType(String type) {

        for (WebElement carType : selectCars) {
            if (carType.getText().contains(type)) {
                System.out.println(type + " car option selected.");
                return;
            }
        }
        Assert.fail("Could not find element type: " + type);
    }

    public void verifyDate(String type) {
            if (datePickerDate.getAttribute("value").equalsIgnoreCase(type)) {
                System.out.println(type + " date is entered.");
                return;
            }

        Assert.fail("Could not find correct date : " + type);
    }

}