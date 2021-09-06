package pages;

import org.apache.bcel.generic.Select;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.Utilities;

import java.util.List;

import static org.apache.commons.collections.CollectionUtils.select;

public class InteractionsPage extends Utilities {

    @FindBy(css = "[id=\"demo-tab-grid\"]")
    public WebElement grid;

    @FindBy(css = "[class=\"list-group-item list-group-item-action\"]")
    public List<WebElement> nums;

    @FindBy(css = "[class=\"create-grid\"] div")
    public WebElement num;

    @FindBy(css = "[id=\"draggable\"]")
    public WebElement draggable;

    @FindBy(css = "[id=\"droppable\"]")
    public WebElement droppable;

    public void dragDrop (String from,String to){
        Actions actions =new Actions(driver);
        for (WebElement groupItem: nums ) {
            System.out.println(groupItem.getText());
            if (groupItem.getText().contains(from)){
                for (WebElement groupItemTo:nums) {
                    if (groupItemTo.getText().contains(to)){
                        int toX = groupItemTo.getLocation().getX();
                        int toY = groupItemTo.getLocation().getY();
                        int X = groupItem.getLocation().getX();
                        int Y = groupItem.getLocation().getY();
                        int difX = toX-X;
                        int difY = toY-Y;
                        actions.moveToElement(groupItem,0,0)
                                .clickAndHold()
                                .dragAndDropBy(groupItem,difX,difY)
                                .build()
                                .perform();

                    }

                }

            }

        }
    }

    public void dragDropBoxees (String from,String to){
        Actions actions =new Actions(driver);
        System.out.println(draggable.getText());

        int toX = droppable.getLocation().getX();
        int toY = droppable.getLocation().getY();
        int X = draggable.getLocation().getX();
        int Y = draggable.getLocation().getY();
        int difX = toX-X;
        int difY = toY-Y;
        actions.moveToElement(draggable,0,0)
                .clickAndHold()
                .dragAndDropBy(draggable,difX,difY)
                .build()
                .perform();

        //                   }


    }



    public void clickGridCards(String cardNumber,String cardNumber2){
        for (WebElement gridCard: nums) {
            if (gridCard.getText().contains(cardNumber)){
                gridCard.click();
            }
            if (gridCard.getText().contains(cardNumber2)){
                gridCard.click();
                return;
            }
        }
        Assert.fail("Could not find card: " + cardNumber);
    }


}