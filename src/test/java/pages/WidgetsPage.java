package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
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

    @FindBy(css = "[class=\"react-datepicker__month\"] div")
    public List<WebElement> days;

    @FindBy(css = "[class=\"react-datepicker__day react-datepicker__day--027\"]")
    public WebElement day27;

    @FindBy(css = "[class=\"nav-menu-container\"] a")
    public List<WebElement> menus;

    public void selectMonth(String monthName){
        for (WebElement month: months) {
            System.out.println(month.getText());
            if (month.getText().contains(monthName)){
                clickElement(month);
                clickElement(monthPicker);
                return;
            }
        }
        Assert.fail("Could not find element type: " + monthName);
    }
    public void selectDay(String dayNumber){
        for (WebElement day: days) {
            System.out.println(day.getText());
            if (day.getText().contains(dayNumber)){
                clickElement(day);
                return;
            }
        }
        Assert.fail("Could not find element type: " + dayNumber);
    }

    public void selectMenu(String menuType){
        Actions actions = new Actions(driver);
        for (WebElement menu: menus) {
            System.out.println(menu.getText());
            actions.moveToElement(menu).perform();
            if (menu.getText().contains(menuType)){
                return;
            }
        }
        Assert.fail("Could not find element type: " + menuType);
    }



}